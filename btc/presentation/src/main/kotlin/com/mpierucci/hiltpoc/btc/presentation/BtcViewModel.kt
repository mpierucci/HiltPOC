package com.mpierucci.hiltpoc.btc.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.mpierucci.android.hiltpoc.btc.domain.Charter
import com.mpierucci.android.hiltpoc.btc.domain.CharterRepository
import kotlinx.coroutines.flow.Flow

internal class BtcViewModel @ViewModelInject constructor(
    repository: CharterRepository
) : ViewModel() {
    val charters: Flow<Result<Charter>> = repository.getCharter()
}