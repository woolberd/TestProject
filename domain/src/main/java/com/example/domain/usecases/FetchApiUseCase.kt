package com.example.domain.usecases

import com.example.domain.repositories.ApiRepository
import javax.inject.Inject

class FetchApiUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {
    operator fun invoke() = apiRepository.fetchApi()
}