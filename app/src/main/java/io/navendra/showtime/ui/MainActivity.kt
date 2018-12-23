package io.navendra.showtime.ui

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.R
import io.navendra.showtime.ui.adapters.ParentShowListAdapter
import io.navendra.showtime.viewmodel.ShowViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    private val profileImage :ImageView = iv_profile
//    private val genreListRecyclerView : RecyclerView = rv_genre_list
    private val showListRecyclerView: RecyclerView = rv_show_list

    private lateinit var showViewModel: ShowViewModel

    val parentShowListAdapter = ParentShowListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showViewModel = ViewModelProviders.of(this).get(ShowViewModel::class.java)
        showViewModel.allShows.observe(this, Observer {shows ->
            shows?.let {
                parentShowListAdapter.setData(it)
            }
        })

        initRecyclers()

    }

    private fun initRecyclers(){
        showListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                    RecyclerView.VERTICAL, false)
            adapter = parentShowListAdapter

        }

//        genreListRecyclerView.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity,
//                    RecyclerView.VERTICAL, false)
//            adapter = GenreAdapter()
//        }
    }





}
