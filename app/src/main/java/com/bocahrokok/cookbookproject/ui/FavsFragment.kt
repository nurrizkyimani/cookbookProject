package com.bocahrokok.cookbookproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.bocahrokok.cookbookproject.R
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.ui.Adapter.CategoryGridAdapter
import com.bocahrokok.cookbookproject.ui.Adapter.FavoriteGridAdapter
import com.bocahrokok.cookbookproject.ui.Adapter.FeaturedListAdapter
import kotlinx.android.synthetic.main.fragment_favs.*

/**
 * A simple [Fragment] subclass.
 */
class FavsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favs, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var featuredItems: ArrayList<FeaturedModel> = ArrayList()

        featuredItems.add(
            FeaturedModel(
                R.drawable.food_1,
                "Frech Omellete"
            )
        )

        featuredItems.add(
            FeaturedModel(
                R.drawable.food_2,
                "Riccotta Gnocc"
            )
        )
        featuredItems.add(
            FeaturedModel(
                R.drawable.food_3,
                "Shimp Soup"
            )
        )

        rv_favorite.also {
            it.layoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false )
            it.setHasFixedSize(true)
            it.adapter =
                FavoriteGridAdapter(
                    featuredItems
                )
        }
    }

}
