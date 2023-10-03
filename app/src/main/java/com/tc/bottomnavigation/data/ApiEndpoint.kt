package com.tc.bottomnavigation.data

import com.tc.bottomnavigation.ui.notifications.data.CatFact
import com.tc.bottomnavigation.ui.notifications.data.CatFactItemModel
import com.tc.bottomnavigation.ui.notifications.data.CatImageItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoint {


    @GET(ApiDetails.FACT_ENDPOINT)
    suspend fun getCatFacts(): Response<ArrayList<CatFactItemModel>>

    @GET(ApiDetails.CAT_IMAGE)
    suspend fun getCatImage(): Response<ArrayList<CatImageItemModel>>


}