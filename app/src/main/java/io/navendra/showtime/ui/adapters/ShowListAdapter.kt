package io.navendra.showtime.ui.adapters

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import io.navendra.showtime.AppConstants.Network as NetworkConstants
import io.navendra.showtime.R
import io.navendra.showtime.data.model.Show
import io.navendra.showtime.utils.ShowTimeLog
import kotlinx.android.synthetic.main.show_item.view.*

class ShowListAdapter(private val glideRequestManager: RequestManager) : RecyclerView.Adapter<ShowListAdapter.ViewHolder>(){

    private var showList: MutableList<Show>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.show_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount() = showList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = showList!![position]

        val posterUrl = (NetworkConstants.TMDB_PHOTO_URL+ show.poster_path).trim()

        ShowTimeLog.d{ "Poster url for ${show.title} is $posterUrl"}

        holder.favouriteImageView.setImageResource(R.drawable.ic_favourite)
        Glide.with(holder.itemView.context)
                .load(posterUrl)
                .apply(
                    RequestOptions()
                        .fitCenter()
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                )
                .into(holder.posterImageView)

        holder.posterImageView.setColorFilter(Color.argb(130, 0, 0, 0))



        holder.ratingTextView.text = show.rating.toString()
        holder.titleTextView.text = show.title
        holder.genreTextView1.text = "Action"
        holder.genreTextView2.text = "Drama"
//        holder.genreTextView1.text = if (show.genres.isNotEmpty()) show.genres[0].title else ""
//        holder.genreTextView2.text = if (show.genres.size >1) show.genres[1].title else ""
        holder.bookNowButton.setOnClickListener { handleBookNowClick(show) }

        val doubleTapListener  = object : GestureDetector.OnDoubleTapListener{
            override fun onDoubleTap(e: MotionEvent?): Boolean {
                handleItemDoubleClick(holder.itemView,show)
                return true
            }

            override fun onDoubleTapEvent(e: MotionEvent?) = true

            override fun onSingleTapConfirmed(e: MotionEvent?) = true

        }

        holder.itemView.apply {
            setOnTouchListener { v, event -> doubleTapListener.onDoubleTap(event) }
            setOnClickListener { handleItemClick(this,show) }
        }

    }

    private fun handleItemClick(view: View, show: Show){
        view.findViewById<ImageView>(R.id.iv_show_item_favorite).setColorFilter(Color.RED)
    }

    private fun handleItemDoubleClick(view: View,show: Show){
//        view.findViewById<ImageView>(R.id.iv_show_item_favorite).setColorFilter(Color.YELLOW)
    }

    private fun handleBookNowClick(show: Show){

    }

    internal fun setData(shows: MutableList<Show>?) {
        this.showList = shows
        notifyDataSetChanged()
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