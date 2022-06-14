package com.todo.presentation.ui.home

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.todo.presentation.R
import com.todo.presentation.databinding.FragmentHomeBinding
import com.todo.presentation.ui.common.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutRes = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModel()

    private val homeListAdapter by lazy { HomeTodoListAdapter(viewModel) }

    override fun initView() {
        initAdapter()
    }

    override fun setBindingVariables() {
        with(binding) {
            homeViewModel = viewModel
            itemCount = homeListAdapter.itemCount
        }
    }

    override fun initObserver() {
        with(viewModel) {
            lifecycleScope.launch {
                addTodo.collect {
                    HomeDialogFragment().show(childFragmentManager, HomeDialogFragment.TAG)
                }
            }
        }
    }

    private fun initAdapter() {
        with(binding.todoRv) {
            adapter = homeListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}