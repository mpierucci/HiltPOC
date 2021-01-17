package com.mpierucci.android.hiltpoc.btc.domain


data class Charter(
    val bpis: List<Bpi>,
    val disclaimer: String,
    val name: String,
    val updated: String,
)


data class Bpi(
    val code: String,
    val description: String,
    val symbol: String,
    val rate: String
)