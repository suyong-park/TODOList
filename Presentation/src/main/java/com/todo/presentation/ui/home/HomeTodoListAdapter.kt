package com.todo.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.todo.domain.home.TodoList
import com.todo.presentation.databinding.ItemTodoListBinding

class HomeTodoListAdapter(private val viewModel: HomeViewModel)
    : ListAdapter<TodoList, HomeTodoListAdapter.HomeTodoListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeTodoListViewHolder(
        ItemTodoListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HomeTodoListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HomeTodoListViewHolder(private val binding: ItemTodoListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TodoList) {
            with(binding) {
                vm = viewModel
                job = item.job
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<TodoList>() {
        override fun areItemsTheSame(oldItem: TodoList, newItem: TodoList) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TodoList, newItem: TodoList) =
            oldItem == newItem
    }
}