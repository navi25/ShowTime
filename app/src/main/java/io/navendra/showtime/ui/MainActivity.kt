package io.navendra.showtime.ui

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.R
import io.navendra.showtime.data.viewmodel.ShowViewModel
import io.navendra.showtime.ui.adapters.GenreAdapter
import io.navendra.showtime.ui.adapters.ParentShowListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val profileImage :ImageView = iv_profile
    private val genreListRecyclerView : RecyclerView = rv_genre_list
    private val showListRecyclerView: RecyclerView = rv_show_list

    private lateinit var showViewModel: ShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showViewModel = ViewModelProviders.of(this).get(ShowViewModel::class.java)
        showViewModel.allShows.observe(this, Observer {shows ->
            shows?.let {
//                adapter.setWords(it)
            }

        })
//        val k = Properties().getProperty("tmdb_key")
//        Log.d("MainActivity",k.toString())
//        initRecyclers()

    }

    private fun initRecyclers(){
        showListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                    RecyclerView.VERTICAL, false)
            adapter = ParentShowListAdapter()

        }


        genreListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                    RecyclerView.VERTICAL, false)
            adapter = GenreAdapter()
        }
    }



}
