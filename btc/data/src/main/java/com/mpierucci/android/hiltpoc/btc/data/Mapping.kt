package com.mpierucci.android.hiltpoc.btc.data

import com.mpierucci.android.hiltpoc.btc.domain.Bpi as DomainBpi
import com.mpierucci.android.hiltpoc.btc.domain.Charter as DomainCharter

internal fun Charter.toEntity(): DomainCharter {
    return DomainCharter(
        updated = time.updated,
        disclaimer = disclaimer,
        name = chartName,
        bpis = bpi.map { bpiEntry -> bpiEntry.value.toEntity() }
    )

}


internal fun Bpi.toEntity(): DomainBpi = DomainBpi(code, description, symbol)
