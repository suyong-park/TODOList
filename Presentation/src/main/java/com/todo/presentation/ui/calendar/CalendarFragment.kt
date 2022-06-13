package com.todo.presentation.ui.calendar

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentCalendarBinding
import com.todo.presentation.ui.common.BaseFragment

class CalendarFragment : BaseFragment<FragmentCalendarBinding, CalendarViewModel>() {

    override val layoutRes = R.layout.fragment_calendar
    override val viewModel: CalendarViewModel by viewModel()

    override fun initView() {

    }

    override fun setBindingVariables() {

    }

    override fun initObserver() {

    }
}