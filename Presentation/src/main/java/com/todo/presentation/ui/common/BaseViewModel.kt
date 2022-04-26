package com.todo.presentation.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _toastEvent = SingleLiveEvent<ToastEvent>()
    val toastEvent : LiveData<ToastEvent> = _toastEvent

    fun onClickUnimplementedFunc() {
        showToast("기능 구현 중입니다.")
    }

    fun showToast(msgStr: String) {
        _toastEvent.value = ToastEvent.fromString(msgStr)
    }

    fun showToast(resID: Int) {
        _toastEvent.value = ToastEvent.fromResId(resID)
    }

    companion object {
        private const val TAG = "BaseViewModel"
    }
}