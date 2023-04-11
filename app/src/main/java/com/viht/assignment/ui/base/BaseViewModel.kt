package com.viht.assignment.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.viht.assignment.util.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    private val _loading = SingleLiveEvent<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> get() = _error

    protected fun showLoading(loading: Boolean) {
        _loading.postValue(loading)
    }

    protected fun handleError(error: String) {
        _error.postValue(error)
    }
}