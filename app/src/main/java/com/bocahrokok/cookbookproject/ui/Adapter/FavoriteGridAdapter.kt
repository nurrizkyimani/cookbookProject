package com.bocahrokok.cookbookproject.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.cookbookproject.R
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.model.GridModel
import kotlinx.android.synthetic.main.favorite_grid.view.*
import kotlinx.android.synthetic.main.featured_list.view.*

class FavoriteGridAdapter(val gridList: List<FeaturedModel>): RecyclerView.Adapter<FavoriteGridAdapter.GridFavoriteViewHolder>() {
 inner class GridFavoriteViewHolder(val listFavorite: View): RecyclerView.ViewHolder(listFavorite)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_grid, parent, false)
        return GridFavoriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridList.size
    }

    override fun onBindViewHolder(holder: GridFavoriteViewHolder, position: Int) {
        holder.listFavorite.apply {
            img_favorite.setImageResource(gridList[position].pict!!)
            tv_favorite.text = gridList[position].name
        }
    }
}