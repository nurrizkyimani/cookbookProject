package com.bocahrokok.cookbookproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.repository.CookbookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException

class HomeViewModel(val repository: CookbookRepository): ViewModel() {
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private var _eventNetworkError = MutableLiveData<Boolean>()
    val eventNetworkError : LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkError = MutableLiveData<Boolean>()
    val  isNetworkError: LiveData<Boolean>
        get() = _isNetworkError

    val list = repository.data

    init {
        fetchRepositoryData()
    }


    fun fetchRepositoryData(){
        viewModelScope.launch {
            try {
                repository.fetchDataInsertRoom()
                _isNetworkError.value = false
                _eventNetworkError.value = false
            } catch (networkError: IOException){
                if(list.value.isNullOrEmpty()){
                    _eventNetworkError.value = true
                }
            }

        }
    }


    override fun onCleared() {
        super.onCleared()
        SupervisorJob().cancel()
    }

}