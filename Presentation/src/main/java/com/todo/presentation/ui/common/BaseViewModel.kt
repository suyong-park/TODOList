package com.todo.presentation.ui.common

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _toastEvent = MutableSharedFlow<Event>()
    val toastEvent = _toastEvent.asSharedFlow()

    fun onClickUnimplementedFunc() {
        showToast("기능 구현 중입니다.")
    }

    fun showToast(msgStr: String) {
        event(Event.ShowToastWithText(msgStr))
    }

    fun showToast(resID: Int) {
        event(Event.ShowToastWithId(resID))
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _toastEvent.emit(event)
        }
    }

    sealed class Event {
        data class ShowToastWithText(val msg: String) : Event()
        data class ShowToastWithId(val resId: Int) : Event()
    }

    companion object {
        private const val TAG = "BaseViewModel"
    }
}