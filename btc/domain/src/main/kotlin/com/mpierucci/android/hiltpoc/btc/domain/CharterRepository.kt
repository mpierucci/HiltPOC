package com.mpierucci.android.hiltpoc.btc.domain

import kotlinx.coroutines.flow.Flow

interface CharterRepository {
    fun getCharter(): Flow<Result<Charter>>
}