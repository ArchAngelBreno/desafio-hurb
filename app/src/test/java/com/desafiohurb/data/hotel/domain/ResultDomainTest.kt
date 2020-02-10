package com.desafiohurb.data.hotel.domain

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ResultDomainTest {

    lateinit var resultDomain: ResultDomain

    @Before
    fun setUp() {
        resultDomain = ResultDomain(
            "Teste",
            "teste teste teste",
            "Muitos caracteres descritos",
             listOf(AmenityDomain("teste", "teste")),
            4,
            1000.0,
            995.0,
            listOf(TaxeDomain("teste taxe",99.0)),
            "https://novo-hu.s3.amazonaws.com/reservas/ota/prod/hotel/2312/buzios-beach-resort-armacao-de-buzios-rj-006_20180319120232.jpg",
            listOf("tag 1", "tag 2"),
            AddressDomain("Rua buzios","Brasil","Buzios bairro","Rio de janeiro","RJ","222231")
        )
    }

    @Test
    fun `Should valid all fields in hotel item`() {
        assertTrue(resultDomain.isValid())
    }

    @Test
    fun `Should return error if cep doest have 8 characteres`() {
        assertTrue(resultDomain.address?.zipcode?.length != 8)
    }

    @Test
    fun `Should show discount between oldPrice and currentPrice`() {
        assert(resultDomain.hotelCurrentPrice!! < resultDomain.hotelOldPrice!!)
    }

}