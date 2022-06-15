package com.todo.presentation.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _toastEvent = MutableSharedFlow<ToastEvent>()
    val toastEvent = _toastEvent.asSharedFlow()

    private val _navigation = MutableSharedFlow<NavigationEvent>()
    val navigation = _navigation.asSharedFlow()

    fun onClickUnimplementedFunc() {
        showToast("기능 구현 중입니다.")
    }

    fun showToast(msgStr: String) {
        toastEvent(ToastEvent.ShowToastWithText(msgStr))
    }

    fun showToast(resID: Int) {
        toastEvent(ToastEvent.ShowToastWithId(resID))
    }

    private fun toastEvent(event: ToastEvent) {
        viewModelScope.launch {
            _toastEvent.emit(event)
        }
    }

    fun navigation(navigation: NavigationEvent) {
        viewModelScope.launch {
            _navigation.emit(navigation)
        }
    }

    sealed class ToastEvent {
        data class ShowToastWithText(val msg: String) : ToastEvent()
        data class ShowToastWithId(val resId: Int) : ToastEvent()
    }

    sealed class NavigationEvent {}
}