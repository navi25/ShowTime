package io.navendra.showtime.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.data.Genre

class GenreAdapter(var genreList: MutableList<Genre>?) : RecyclerView.Adapter<GenreAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount() = genreList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }


}