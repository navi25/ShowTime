package io.navendra.showtime.ui

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val profileImage :ImageView = iv_profile
    private val genreListRecyclerView : RecyclerView = rv_genre_list
    private val showListRecyclerView: RecyclerView = rv_show_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
