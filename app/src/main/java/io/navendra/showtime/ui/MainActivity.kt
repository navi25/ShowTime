package io.navendra.showtime.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.R
import io.navendra.showtime.ui.adapters.GenreAdapter
import io.navendra.showtime.ui.adapters.ParentShowListAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val profileImage :ImageView = iv_profile
    private val genreListRecyclerView : RecyclerView = rv_genre_list
    private val showListRecyclerView: RecyclerView = rv_show_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclers()

    }

    private fun initRecyclers(){
        showListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                    RecyclerView.VERTICAL, false)
            adapter = ParentShowListAdapter(null)

        }


        genreListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                    RecyclerView.VERTICAL, false)
            adapter = GenreAdapter(null)
        }
    }

}
