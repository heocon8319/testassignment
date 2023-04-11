package com.viht.assignment.data.remote.api

import com.viht.assignment.data.remote.response.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v1/75e79553-ab98-46a3-becd-10adbdc3fb43")
    suspend fun getNewsAsync(): Response<DataResponse>
}