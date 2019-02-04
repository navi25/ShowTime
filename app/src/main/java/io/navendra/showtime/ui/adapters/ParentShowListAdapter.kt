package io.navendra.showtime.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import io.navendra.showtime.R
import io.navendra.showtime.data.model.ParentShowList
import kotlinx.android.synthetic.main.rv_shows_view.view.*

class ParentShowListAdapter(private val glideRequestManager: RequestManager) : RecyclerView.Adapter<ParentShowListAdapter.ViewHolder>(){

    private var parentLiveData : MutableLiveData<MutableList<ParentShowList>>? = null
    private var parentShowLists: MutableList<ParentShowList>? = null
    private val viewPool = RecyclerView.RecycledViewPool()
    private var showAdapters = mutableListOf<ShowListAdapter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_shows_view,
                parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount() = parentShowLists?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parentShowLists!![position]


        holder.titleTextView.text = parent.category

        val childLayoutManager = LinearLayoutManager( holder.showListRecyclerView.context,
                LinearLayout.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4

        holder.showListRecyclerView.apply {
            setHasFixedSize(true)
            adapter = ShowListAdapter(glideRequestManager).apply {
                setData(parent.shows)
            }
            layoutManager = childLayoutManager
            setRecycledViewPool(viewPool)
            addItemDecoration(DividerItemDecoration(holder.itemView.context, VERTICAL))
        }

    }

    internal fun setData(parentShowLists: MutableList<ParentShowList>?) {
        this.parentShowLists = parentShowLists
        notifyDataSetChanged()
    }

    internal fun setLiveData(parentLiveData: MutableLiveData<MutableList<ParentShowList>>){
        this.parentLiveData = parentLiveData
        this.parentShowLists = this.parentLiveData?.value
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.list_title
        val showListRecyclerView: RecyclerView = itemView.rv_showLists
    }
}