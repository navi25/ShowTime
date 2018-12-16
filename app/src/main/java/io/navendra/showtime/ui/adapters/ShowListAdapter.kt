package io.navendra.showtime.ui.adapters

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.R
import io.navendra.showtime.data.Show
import kotlinx.android.synthetic.main.show_item.view.*

class ShowListAdapter(var showList: MutableList<Show>?) : RecyclerView.Adapter<ShowListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount() = showList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = showList!![position]

        holder.posterImageView.setImageBitmap(show.posterBitmap)
        holder.favouriteImageView.setImageResource(R.drawable.ic_favourite)
        holder.ratingTextView.text = show.rating.toString()
        holder.titleTextView.text = show.title
        holder.genreTextView1.text = if (show.genres.isNotEmpty()) show.genres[0].title else ""
        holder.genreTextView2.text = if (show.genres.size >1) show.genres[1].title else ""
        holder.bookNowButton.setOnClickListener { handleBookNowClick(show) }

        val doubleTapListener  = object : GestureDetector.OnDoubleTapListener{
            override fun onDoubleTap(e: MotionEvent?): Boolean {
                handleItemDoubleClick(show)
                return true
            }

            override fun onDoubleTapEvent(e: MotionEvent?) = true

            override fun onSingleTapConfirmed(e: MotionEvent?) = true

        }

        holder.itemView.apply {
            setOnTouchListener { v, event -> doubleTapListener.onDoubleTap(event) }
            setOnClickListener { handleItemClick(show) }
        }

    }


    private fun handleItemClick(show:Show){

    }

    private fun handleItemDoubleClick(show:Show){

    }

    private fun handleBookNowClick(show: Show){

    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val posterImageView: ImageView = itemView.iv_show_item_poster
        val favouriteImageView: ImageView = itemView.iv_show_item_favorite
        val ratingTextView: TextView = itemView.tv_show_item_rating
        val titleTextView: TextView = itemView.tv_show_item_title
        val genreTextView1: TextView = itemView.tv_show_time_genre1
        val genreTextView2: TextView = itemView.tv_show_time_genre2
        val bookNowButton: Button = itemView.btn_show_time_bookNow
    }
}