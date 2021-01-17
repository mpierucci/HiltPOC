package com.mpierucci.android.hiltpoc.btc.data

import com.mpierucci.android.hiltpoc.btc.domain.Charter
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.CancellationException
import javax.inject.Inject
import com.mpierucci.android.hiltpoc.btc.domain.Charter as DomainCharter
import com.mpierucci.android.hiltpoc.btc.domain.CharterRepository as DomainCharterRepository

internal class CharterRepository @Inject constructor(
    private val btcApi: BtcApi
) : DomainCharterRepository {

    override fun getCharter(): Flow<Result<Charter>> {
        return flow {
            while (true) {
                try {
                    val charter = btcApi.getCharter().toEntity()
                    emit(Result.success(charter))
                    delay(1000)
                } catch (cancellation: CancellationException) {
                    throw cancellation
                } catch (ex: Exception) {
                    emit(Result.failure<DomainCharter>(ex))
                }
            }
        }
    }
}