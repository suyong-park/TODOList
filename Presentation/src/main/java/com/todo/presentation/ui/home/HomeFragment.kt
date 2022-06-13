package com.todo.presentation.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentHomeBinding
import com.todo.presentation.ext.gone
import com.todo.presentation.ext.visible
import com.todo.presentation.ui.common.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutRes = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    private val homeListAdapter by lazy { HomeTodoListAdapter(viewModel) }

    override fun initView() {
        with(binding.todoRv) {
            adapter = homeListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        showEmptyTodoList()
    }

    override fun setBindingVariables() {
        binding.homeViewModel = viewModel
    }

    override fun initObserver() {
        with(viewModel) {
            lifecycleScope.launch {
                addTodo.collect {
                    HomeDialogFragment().show(childFragmentManager, "")
                }
            }
        }
    }

    private fun showEmptyTodoList() {
        with(binding.emptyTodoListLayout) {
            if (homeListAdapter.itemCount == 0) {
                visible()
            } else {
                gone()
            }
        }
    }
}