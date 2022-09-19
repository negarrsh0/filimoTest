package ir.anaridroid.testf.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.anaridroid.testf.data.model.Attributes
import ir.anaridroid.testf.data.model.Data
import ir.anaridroid.testf.databinding.ItemLayoutBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    //diff util list________________________________________________________________________________
    private val diffCallback = object : DiffUtil.ItemCallback<Attributes>(){
        override fun areItemsTheSame(oldItem: Attributes, newItem: Attributes): Boolean {
            return oldItem.sid == newItem.sid
        }

        override fun areContentsTheSame(oldItem: Attributes, newItem: Attributes): Boolean {
            return newItem == oldItem
        }
    }
    private val differ = AsyncListDiffer(this,diffCallback)
    var attrList : List<Attributes>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }
    //______________________________________________________________________________________________




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movieList = attrList[position]
        holder.binding.txtTitle.text = movieList.movie_title


    }

    override fun getItemCount(): Int = attrList.size

    class MovieViewHolder(val binding:ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}