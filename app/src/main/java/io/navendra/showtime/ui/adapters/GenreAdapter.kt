package io.navendra.showtime.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.R
import io.navendra.showtime.data.model.Genre
import kotlinx.android.synthetic.main.genre_item.view.*

class GenreAdapter : RecyclerView.Adapter<GenreAdapter.ViewHolder>(){

    private var genreList: MutableList<Genre>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.genre_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = genreList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genre = genreList!![position]
        holder.imageView.setImageResource(genre.imageBitmap!!)
        holder.titleView.text = genre.title
    }

    internal fun setData(genres: MutableList<Genre>?) {
        this.genreList = genres
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.genreImage
        val titleView: TextView = itemView.genreName
    }

}