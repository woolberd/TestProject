package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.remote.apiservice.ApiService
import com.example.data.remote.dtos.toDomain
import com.example.domain.models.Response
import com.example.domain.repositories.ApiRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepositoryImpl @Inject constructor(
    private val service: ApiService
) : ApiRepository, BaseRepository() {

    override fun fetchApi() = doRequest {
        service.fetchApi().map {
            it.toDomain()
        }
    }

    override fun fetchDetail(id: String): Flow<Resource<Response>> = doRequests {
        service.fetchDetail(id).toDomain()
    }
}