package com.viht.assignment.repository

import com.viht.assignment.data.remote.api.ApiHelper
import com.viht.assignment.data.remote.api.ApiResponse
import com.viht.assignment.data.remote.api.ApiResult
import com.viht.assignment.data.remote.response.DataResponse
import com.viht.assignment.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiHelper: ApiHelper,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ApiResponse() {

    suspend fun getNews(): Flow<ApiResult<DataResponse>> {
        return flow {
            val result = safeApiCall { apiHelper.getNews() }
            emit(result)
        }.flowOn(dispatcher)//Dispatchers.IO
    }
}