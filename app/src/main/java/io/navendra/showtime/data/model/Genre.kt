package io.navendra.showtime.data.model

import android.graphics.Bitmap
import io.navendra.showtime.R

data class Genre (
        val id:Int,
        val title:String,
        val image:String,
        val imageBitmap: Int?
){

    companion object {
        fun getDummy(): MutableList<Genre>{
            val genres = mutableListOf<Genre>()
            val titles = arrayListOf("ACTION", "DRAMA", "COMEDY", "ROMANCE")
            var id = 0
            repeat(titles.size){
                genres.add(Genre(id,titles.get(id),"", R.drawable.kungfu))
            }
            return genres
        }
    }
}