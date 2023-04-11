package com.viht.assignment.ui.checkin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.viht.assignment.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckInViewModel @Inject constructor(): BaseViewModel() {
    // TODO: Implement the ViewModel
    private val _text = MutableLiveData<String>().apply {
        value = "This is Check In Fragment"
    }
    val text: LiveData<String> = _text
}