package com.mpierucci.android.hiltpoc.btc.data

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import com.mpierucci.android.hiltpoc.btc.domain.Charter as DomainCharter

@ExperimentalCoroutinesApi
class CharterRepositoryTest {

    private val api = mock<BtcApi>()

    @Test
    fun `emits mapped api results`() = runBlockingTest {
        val charter = Charter(emptyMap(), "", "", Time(""))
        val expectedCharter = charter.toEntity()
        given(api.getCharter()).willReturn(charter)

        val sut = CharterRepository(api)

        val actual = sut.getCharter().first()

        assertThat(actual.isSuccess)
        assertThat(expectedCharter).isEqualTo(actual.getOrNull())
    }

    @Test
    fun `emits exception`() = runBlockingTest {
        Result.failure<DomainCharter>(IllegalStateException())
        given(api.getCharter()).willThrow(IllegalStateException())

        val sut = CharterRepository(api)

        val actual = sut.getCharter().first()

        assertThat(actual.isFailure)
    }
}