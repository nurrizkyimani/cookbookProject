package com.bocahrokok.cookbookproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bocahrokok.cookbookproject.repository.CookbookRepository


class HomeViewModelProviderFactory(val repository: CookbookRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }

}