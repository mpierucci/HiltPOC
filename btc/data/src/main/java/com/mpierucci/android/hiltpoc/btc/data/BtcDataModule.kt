package com.mpierucci.android.hiltpoc.btc.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit
import com.mpierucci.android.hiltpoc.btc.domain.CharterRepository as DomainCharterRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
object BtcDataModule {

    @Provides
    internal fun provideBtcApi(retrofit: Retrofit): BtcApi = retrofit.create(BtcApi::class.java)

    @Provides
    internal fun provideCharterRepository(charterRepository: CharterRepository)
            : DomainCharterRepository = charterRepository
}