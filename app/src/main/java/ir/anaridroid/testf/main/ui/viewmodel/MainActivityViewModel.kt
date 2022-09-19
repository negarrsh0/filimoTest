package ir.anaridroid.testf.main.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import ir.anaridroid.testf.data.model.Attributes
import ir.anaridroid.testf.data.model.Data
import ir.anaridroid.testf.repository.FilimoRepository
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val repository: FilimoRepository) : ViewModel(){

    fun getAllMovies() : Observable<List<Attributes>> = repository.getAllMovies()
}