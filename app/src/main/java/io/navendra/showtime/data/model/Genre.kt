package io.navendra.showtime.data.model

import android.graphics.Bitmap

data class Genre (
        val id:Int,
        val title:String,
        val image:String,
        val imageBitmap: Bitmap?
)