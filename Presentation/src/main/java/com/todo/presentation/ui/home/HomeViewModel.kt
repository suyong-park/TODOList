package com.todo.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.todo.presentation.ui.common.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val _addTodo = MutableSharedFlow<Any>()
    val addTodo = _addTodo.asSharedFlow()

    fun onClickAddTodo() {
        event(Event.Add)
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _addTodo.emit(event)
        }
    }

    sealed class Event {
        object Add : Event()
    }
}