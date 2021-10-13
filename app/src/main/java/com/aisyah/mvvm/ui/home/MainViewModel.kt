package com.aisyah.mvvm.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aisyah.mvvm.data.model.ResponseNews
import com.aisyah.mvvm.data.repository.NewsRepository
import com.aisyah.mvvm.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
//inject repository
class MainViewModel @Inject constructor(private val repository: NewsRepository): ViewModel(){
    private val _newsData = MutableLiveData<Resource<ResponseNews>>()
    val newsData = _newsData
    init {
        fetchNewsViewModel()
    }

    //viewmodelscope = tempat coroutine berjalan
    private fun fetchNewsViewModel() = viewModelScope.launch {
        _newsData.value = Resource.Loading

        repository.fetchDataNews().collect{news -> _newsData.value = news}
    }
}