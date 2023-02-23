package com.wilson.porcentajewilsontenpo.services.percentage.impl;

import com.wilson.porcentajewilsontenpo.utils.TestDataFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@AutoConfigureWebTestClient
class PercentageImplTest {

    @InjectMocks
    PercentageImpl percentageImpl;
    public static String auth = "wilson3042258679";

    @Test
    void sumaAplicandoPorcentajeApiAuthNull() {
        var response = percentageImpl.sumaAplicandoPorcentaje(null,
                TestDataFactory.CLIENT_ID, TestDataFactory.getPercentageRequestDto());
        assertEquals(1012, response.getResponseCode());
    }

    @Test
    void sumaAplicandoPorcentajeClientUuid() {
        ReflectionTestUtils.setField(percentageImpl, "auth", auth);
        var response = percentageImpl.sumaAplicandoPorcentaje(TestDataFactory.AUTH,
                null, TestDataFactory.getPercentageRequestDto());
        assertEquals(1013, response.getResponseCode());
    }

    @Test
    void sumaAplicandoPorcentajeValueSumaNull() {
        ReflectionTestUtils.setField(percentageImpl, "auth", auth);
        var response = percentageImpl.sumaAplicandoPorcentaje(TestDataFactory.AUTH,
                TestDataFactory.CLIENT_ID, TestDataFactory.getPercentageRequestDtoMenorSuma());
        assertEquals(1014, response.getResponseCode());
    }

    @Test
    void sumaAplicandoPorcentajeNull() {
        ReflectionTestUtils.setField(percentageImpl, "auth", auth);
        var response = percentageImpl.sumaAplicandoPorcentaje(TestDataFactory.AUTH,
                TestDataFactory.CLIENT_ID, TestDataFactory.getPercentageRequestDtoPorcenatjeMenor());
        assertEquals(1015, response.getResponseCode());
    }

    @Test
    void sumaAplicandoApiAuthEquals() {
        ReflectionTestUtils.setField(percentageImpl, "auth", auth);
        var response = percentageImpl.sumaAplicandoPorcentaje(TestDataFactory.AUTH,
                TestDataFactory.CLIENT_ID, TestDataFactory.getPercentageRequestDto());
        assertEquals(0, response.getResponseCode());
    }

}