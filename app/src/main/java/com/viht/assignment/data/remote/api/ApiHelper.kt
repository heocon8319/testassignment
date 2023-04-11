package com.viht.assignment.data.remote.api

import com.viht.assignment.data.remote.response.DataResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getNews(): Response<DataResponse>
}