package com.exercise.summaryfive.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise.summaryfive.BaseFragment
import com.exercise.summaryfive.data.adapter.CourseAdapter
import com.exercise.summaryfive.databinding.FragmentMainPageBinding
import kotlinx.coroutines.launch

class MainPageFragment: BaseFragment<FragmentMainPageBinding>(FragmentMainPageBinding::inflate) {
    private val viewModel: MainPageViewModel by viewModels()
    private lateinit var courseAdapter: CourseAdapter

    override fun setUp() {
        setUpRecyclerView()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dataFlow.collect { data ->
                data?.let {
                    courseAdapter.submitList(it)
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        courseAdapter = CourseAdapter()
        binding.recyclerViewOne.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = courseAdapter
        }
    }
}
