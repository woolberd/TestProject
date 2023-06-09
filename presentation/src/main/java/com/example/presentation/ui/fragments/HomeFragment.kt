package com.example.presentation.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.state.UIState
import com.example.presentation.ui.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home){

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val adapter = HomeAdapter(this::onItemClick)

    override fun initialize() {
       binding.recView.adapter = adapter
    }

    override fun setupSubscribes() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dataState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Log.e("error", it.error)
                        }
                        is UIState.Loading -> {
                        }
                        is UIState.Success -> {
                            adapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        )
    }
}