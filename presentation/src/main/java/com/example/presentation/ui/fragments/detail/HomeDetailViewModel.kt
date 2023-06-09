package com.example.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.FetchDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeDetailViewModel @Inject constructor(
    private val fetchDetailUseCase: FetchDetailUseCase
) : ViewModel() {

    fun fetchDetail(id: String) = fetchDetailUseCase.invoke(id)
}