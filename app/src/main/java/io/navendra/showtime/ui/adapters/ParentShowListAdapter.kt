package io.navendra.showtime.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.R
import io.navendra.showtime.data.ParentShowList
import kotlinx.android.synthetic.main.rv_shows_view.view.*

class ParentShowListAdapter(private val parentShowLists: MutableList<ParentShowList>?)
    : RecyclerView.Adapter<ParentShowListAdapter.ViewHolder>(){

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_shows_view,
                parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount() = parentShowLists?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parentShowLists!![position]

        holder.titleTextView.text = parent.genre.title

        val childLayoutManager = LinearLayoutManager( holder.showListRecyclerView.context,
                LinearLayout.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4

        holder.showListRecyclerView.apply {
            setHasFixedSize(true)
            adapter = ShowListAdapter(parent.shows)
            layoutManager = childLayoutManager
            setRecycledViewPool(viewPool)
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.list_title
        val showListRecyclerView: RecyclerView = itemView.rv_showLists
    }
}