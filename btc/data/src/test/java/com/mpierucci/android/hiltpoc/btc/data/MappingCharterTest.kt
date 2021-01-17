package com.mpierucci.android.hiltpoc.btc.data

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import com.mpierucci.android.hiltpoc.btc.domain.Bpi as DomainBpi
import com.mpierucci.android.hiltpoc.btc.domain.Charter as DomainCharter

class MappingCharterTest {

    @Test
    fun `maps dto into entity`() {
        val bpiEntity = DomainBpi("code", "desc", "symbol","rate")
        val expected = DomainCharter(
            disclaimer = "disc",
            name = "name",
            updated = "updated",
            bpis = listOf(bpiEntity)
        )

        val bpi = Bpi("code", "desc", "symbol","rate")
        val sut = Charter(
            disclaimer = "disc",
            chartName = "name",
            time = Time("updated"),
            bpi = mapOf("EUR" to bpi)
        )

        val actual = sut.toEntity()

        assertThat(actual).isEqualTo(expected)
    }
}