package com.mpierucci.android.hiltpoc.btc.data

import retrofit2.http.GET

internal interface BtcApi {

    @GET("bpi/currentprice.json")
    suspend fun getCharter(): Charter
}