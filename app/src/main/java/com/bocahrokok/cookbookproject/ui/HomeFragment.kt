package com.bocahrokok.cookbookproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.bocahrokok.cookbookproject.R
import com.bocahrokok.cookbookproject.database.HomeDatabase
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.model.GridModel
import com.bocahrokok.cookbookproject.repository.CookbookRepository
import com.bocahrokok.cookbookproject.ui.Adapter.CategoryGridAdapter
import com.bocahrokok.cookbookproject.ui.Adapter.FeaturedListAdapter
import com.bocahrokok.cookbookproject.viewmodels.HomeViewModel
import com.bocahrokok.cookbookproject.viewmodels.HomeViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var gridItems: ArrayList<GridModel> = ArrayList()

        gridItems.add(
            GridModel(
                R.drawable.ic_grid1,
                "For Beginner"
            )
        )
        gridItems.add(
            GridModel(
                R.drawable.ic_grid2,
                "30 mins or less"
            )
        )
        gridItems.add(
            GridModel(
                R.drawable.ic_grid3,
                "Vegetarian"
            )
        )
        gridItems.add(
            GridModel(
                R.drawable.ic_grid4,
                "Baking Class"
            )
        )

        gridItems.add(
            GridModel(
                R.drawable.ic_grid5,
                "Beverages"
            )
        )
        gridItems.add(
            GridModel(
                R.drawable.ic_grid6,
                "Crowd' Favorite"
            )
        )

        explore_category.also {
            it.layoutManager = GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false )
            it.setHasFixedSize(true)
            it.adapter =
                CategoryGridAdapter(
                    gridItems
                )
        }

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

        rv_featured.also {
            it.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false )
            it.setHasFixedSize(true)
            it.adapter =
                FeaturedListAdapter(
                    featuredItems
                )
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository =  CookbookRepository(HomeDatabase.invoke(requireContext()))
        val ListViewModelProviderFactory2 = HomeViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, ListViewModelProviderFactory2).get(HomeViewModel::class.java)


// setup navigation with root destinations and toolbar
//        NavigationUI.setupWithNavController(bottom_navigation, navController)
//        val navController = findNavController(R.id.bottom_navigation)

    }

}
