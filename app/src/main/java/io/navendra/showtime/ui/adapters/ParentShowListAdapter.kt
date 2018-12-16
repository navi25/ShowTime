package io.navendra.showtime.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.navendra.showtime.data.ParentShowList

class ParentShowListAdapter(val parentShowLists: MutableList<ParentShowList>)
    : RecyclerView.Adapter<ParentShowListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}