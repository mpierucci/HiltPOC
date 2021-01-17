package com.mpierucci.android.hiltpoc.btc.data

internal data class Charter(
    val bpi: Map<String, Bpi>,
    val disclaimer: String,
    val chartName: String,
    val time: Time,
)


internal data class Bpi(
    val code: String,
    val description: String,
    val symbol: String,
)

data class Time(val updated: String)