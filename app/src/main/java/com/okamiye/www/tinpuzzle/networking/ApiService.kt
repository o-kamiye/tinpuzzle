package com.okamiye.www.tinpuzzle.networking

import retrofit2.http.GET

/**
 * ApiService -
 */
interface ApiService {

    @GET("images")
    fun getImages()
}