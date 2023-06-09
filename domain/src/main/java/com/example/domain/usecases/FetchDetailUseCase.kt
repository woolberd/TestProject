package com.example.domain.usecases

import com.example.domain.repositories.ApiRepository
import javax.inject.Inject

class FetchDetailUseCase @Inject constructor(
    private val repository: ApiRepository
) {

    operator fun invoke(id: String) = repository.fetchDetail(id)
}