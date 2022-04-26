package com.todo.presentation.ui.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.todo.domain.home.TodoList
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentHomeBinding
import com.todo.presentation.ui.common.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutRes = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    private val homeListAdapter by lazy { HomeTodoListAdapter(viewModel) }
    private lateinit var dummyList: List<TodoList>

    override fun initView() {
        with(binding.todoRv) {
            adapter = homeListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        setDummyData()
        homeListAdapter.submitList(dummyList)
    }

    override fun setBindingVariables() {
    }

    override fun initObserver() {
    }

    private fun setDummyData() {
        dummyList = listOf<TodoList>(
            TodoList(1, "test1"),
            TodoList(2, "테스트"),
            TodoList(3, "리사이클러뷰"),
            TodoList(4, "안드로이드 리사이클러뷰"),
            TodoList(5, "테스트 중입니다."),
            TodoList(6, "더미 데이터 입니다."),
            TodoList(7, "토이 프로젝트입니다."),
            TodoList(8, "테스트 진행합니다."),
            TodoList(9, "안드로이드 MVVM 공부중입니다."),
            TodoList(10, "spdlqjfire@naver.com"),
            TodoList(11, "즐거운 TODO List")
        )
    }
}