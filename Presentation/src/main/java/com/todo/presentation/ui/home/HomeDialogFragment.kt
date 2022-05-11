package com.todo.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.todo.presentation.R
import com.todo.presentation.databinding.DialogHomeAddTodoBinding

class HomeDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: DialogHomeAddTodoBinding

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.dialog_home_add_todo, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}