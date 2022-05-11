package com.todo.presentation.ui.home

import androidx.lifecycle.LiveData
import com.todo.presentation.ui.common.BaseViewModel
import com.todo.presentation.ui.common.SingleLiveEvent

class HomeViewModel : BaseViewModel() {

    private val _addTodo = SingleLiveEvent<Boolean>()
    val addTodo : LiveData<Boolean> = _addTodo

    fun onClickAddTodo() {
        _addTodo.value = true
    }
}