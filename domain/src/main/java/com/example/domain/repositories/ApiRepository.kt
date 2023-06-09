package com.example.domain.repositories

import com.example.domain.models.Response
import com.example.domain.utils.Either
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ApiRepository {

    fun fetchApi(): Flow<Either<String, List<Response>>>

    fun fetchDetail(id: String): Flow<Resource<Response>>
}