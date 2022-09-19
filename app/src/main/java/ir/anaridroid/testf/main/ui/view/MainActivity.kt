package ir.anaridroid.testf.main.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.anaridroid.testf.data.model.Attributes
import ir.anaridroid.testf.databinding.ActivityMainBinding
import ir.anaridroid.testf.main.adapter.MovieAdapter
import ir.anaridroid.testf.main.ui.viewmodel.MainActivityViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainViewModel: MainActivityViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var movieAdapter: MovieAdapter
    lateinit var disposable : Disposable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllMovie()

    }

    //fun for fetch all movie
    //______________________________________________________________________________________________
    private fun getAllMovie() {
        mainViewModel.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Attributes>> {
                override fun onSubscribe(d: Disposable) {
                    disposable =d
                }

                override fun onNext(movieList: List<Attributes>) {
                    movieAdapter = MovieAdapter()
                    binding.recyclerView.apply {
                        layoutManager = LinearLayoutManager(
                            this@MainActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        setHasFixedSize(true)
                        adapter = movieAdapter
                        movieAdapter.attrList = movieList
                        //search by movie title
                        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
                            var filteredList = ArrayList<Attributes>()
                            override fun onQueryTextSubmit(query: String?): Boolean {
                                return false
                            }

                            override fun onQueryTextChange(newText: String?): Boolean {
                                for (movie in movieList) {
                                    if (movie.movie_title.contains(newText.toString())) {
                                        filteredList.add(movie)
                                    }else{
                                        Toast.makeText(this@MainActivity, "این محتوا موجود نیست", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                return false
                            }
                        })
                    }
                }
                override fun onError(e: Throwable) {
                    Toast.makeText(this@MainActivity, "لطفا اتصال اینترنت خود را بررسی کنید", Toast.LENGTH_SHORT).show()
                }

                override fun onComplete() {
                }

            })
    }
    //______________________________________________________________________________________________
}



