package com.todo.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.todo.presentation.ui.common.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeDialogViewModel : BaseViewModel() {

    private val _isDone = MutableSharedFlow<Any>()
    val isDone = _isDone.asSharedFlow()

    fun onClickAddTodoBtn() {
        event(Event.AddTodo)
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _isDone.emit(event)
        }
    }

    sealed class Event {
        object AddTodo : Event()
    }
}