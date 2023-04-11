package com.viht.assignment.data.remote.api

import com.viht.assignment.data.remote.response.DataResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImp @Inject constructor(private val apiService: ApiService): ApiHelper  {

    override suspend fun getNews(): Response<DataResponse> {
        return apiService.getNewsAsync()
    }
}