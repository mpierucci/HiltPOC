package com.mpierucci.android.hiltpoc.btc.data

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import com.mpierucci.android.hiltpoc.btc.domain.Bpi as DomainBpi

class MappingBpiTest {

    @Test
    fun `maps dto into entity`() {
        val expected = DomainBpi("code", "desc", "symbol")

        val sut = Bpi("code", "desc", "symbol")

        val actual = sut.toEntity()

        assertThat(actual).isEqualTo(expected)
    }
}