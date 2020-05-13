package com.bocahrokok.cookbookproject.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bocahrokok.cookbookproject.R
import com.bocahrokok.cookbookproject.model.GridModel
import kotlinx.android.synthetic.main.category_grid.view.*

class CategoryGridAdapter(val gridList: List<GridModel>): RecyclerView.Adapter<CategoryGridAdapter.GridCategoryViewHolder>() {

    inner class GridCategoryViewHolder(val gridCategory: View): RecyclerView.ViewHolder(gridCategory)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_grid, parent, false)
        return GridCategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridList.size
    }

    override fun onBindViewHolder(holder: GridCategoryViewHolder, position: Int) {
        holder.gridCategory.apply {
            img_ilus.setImageResource(gridList[position].iconGrid!!)
            tv_ilus.text = gridList[position].titleGrid
        }
    }

}