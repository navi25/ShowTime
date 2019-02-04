package io.navendra.showtime.ui


import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.navendra.showtime.R
import io.navendra.showtime.data.model.Genre
import io.navendra.showtime.ui.adapters.GenreAdapter
import io.navendra.showtime.ui.adapters.ParentShowListAdapter
import io.navendra.showtime.utils.ShowTimeLog as Log
import io.navendra.showtime.viewmodel.ShowViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    private val profileImage :ImageView = iv_profile
//    private val genreListRecyclerView : RecyclerView = rv_genre_list
    private lateinit var showListRecyclerView: RecyclerView

    private lateinit var showViewModel: ShowViewModel

    private lateinit var  parentShowListAdapter : ParentShowListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showListRecyclerView = rv_show_list
        parentShowListAdapter = ParentShowListAdapter(Glide.with(this))
        showViewModel = ViewModelProviders.of(this).get(ShowViewModel::class.java)


        Log.d { "Fetching All Shows from ViewModel" }
        showViewModel.fetchAllShows()

        showViewModel.allShows.observe(this, Observer {
            parentShowListAdapter.setData(it)
        })

        initRecyclers()
    }

    private fun initRecyclers(){
        showListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                    RecyclerView.VERTICAL, false)
            adapter = parentShowListAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }

//        rv_genre_list.visibility = View.GONE
        rv_genre_list.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = GenreAdapter().apply { setData(Genre.getDummy()) }

        }
    }





}
