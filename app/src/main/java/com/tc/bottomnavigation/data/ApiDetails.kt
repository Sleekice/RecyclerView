package com.tc.bottomnavigation.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {

    // https://cat-fact.herokuapp.com/facts
    const val BASE_URL = "https://cat-fact.herokuapp.com/"
    const val FACT_ENDPOINT = "facts"

    const val CAT_IMAGE = "https://api.thecatapi.com/v1/images/search"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(ApiEndpoint::class.java)

}