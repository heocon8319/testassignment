package com.viht.assignment.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.viht.assignment.data.remote.api.ApiResult
import com.viht.assignment.data.remote.response.DataResponse
import com.viht.assignment.repository.NewsRepository
import com.viht.assignment.ui.base.BaseViewModel
import com.viht.assignment.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repo: NewsRepository): BaseViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is News Fragment"
    }
    val text: LiveData<String> = _text

    //@Inject constructor(private val repo: NewsRepository)
    private val _response: SingleLiveEvent<DataResponse?> = SingleLiveEvent()
    val response: LiveData<DataResponse?> get() = _response

    init {
        loadNews()
    }

    // getting news list using repository and passing it into live data
    private fun loadNews() {
        showLoading(true)
        viewModelScope.launch {
            repo.getNews().collect { values ->
                when (values) {
                    is ApiResult.Success -> {
                        _response.postValue(values.data)
                        showLoading(false)
                    }
                    is ApiResult.Error -> {
                        handleError(values.message ?: "")
                        showLoading(false)
                    }
                    is ApiResult.Loading -> {
                        showLoading(true)
                    }
                }
            }
        }
    }
}