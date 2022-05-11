package com.todo.presentation.ui.home

import androidx.lifecycle.LiveData
import com.todo.presentation.ui.common.BaseViewModel
import com.todo.presentation.ui.common.SingleLiveEvent

class HomeDialogViewModel : BaseViewModel() {

    private val _isDone = SingleLiveEvent<Boolean>()
    val isDone: LiveData<Boolean> = _isDone

    fun onClickAddTodoBtn() {
        _isDone.value = true
    }
}