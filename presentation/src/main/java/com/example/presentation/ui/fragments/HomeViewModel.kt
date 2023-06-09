package com.example.presentation.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.FetchApiUseCase
import com.example.domain.utils.Either
import com.example.presentation.models.ResponseUI
import com.example.presentation.models.toUI
import com.example.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchApi: FetchApiUseCase
) : ViewModel() {

    private val _dataState = MutableStateFlow<UIState<List<ResponseUI>>>(UIState.Loading())
    val dataState get() = _dataState.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            fetchApi().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { error ->
                            _dataState.value = UIState.Error(error)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {
                            _dataState.value = UIState.Success(it.map { anime ->
                                anime.toUI()
                            })
                        }
                    }
                }
            }
        }
    }
}