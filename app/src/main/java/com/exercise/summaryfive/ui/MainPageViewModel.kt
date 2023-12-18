package com.exercise.summaryfive.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.summaryfive.data.model.ActiveCourse
import com.exercise.summaryfive.data.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainPageViewModel:ViewModel() {
    private val _dataFlow = MutableStateFlow<List<ActiveCourse>?>(null)
    val dataFlow: StateFlow<List<ActiveCourse>?> get() = _dataFlow

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = ApiClient.networkApiService.get()
                _dataFlow.value = response.activeCourse
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
