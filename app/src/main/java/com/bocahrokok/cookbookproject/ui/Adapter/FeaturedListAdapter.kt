package com.bocahrokok.cookbookproject.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.cookbookproject.R
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.model.GridModel
import kotlinx.android.synthetic.main.featured_list.view.*

class FeaturedListAdapter(val gridList: List<FeaturedModel>): RecyclerView.Adapter<FeaturedListAdapter.FeaturedListViewHolder>() {
    inner class FeaturedListViewHolder(val listFeatured: View): RecyclerView.ViewHolder(listFeatured)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.featured_list, parent, false)
        return FeaturedListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridList.size
    }

    override fun onBindViewHolder(holder: FeaturedListViewHolder, position: Int) {
        holder.listFeatured.apply {
            img_featured.setImageResource(gridList[position].pict!!)
            tv_featured.text = gridList[position].name
        }
    }


}