package com.wilson.porcentajewilsontenpo.controller;

import com.wilson.porcentajewilsontenpo.ddr.IDdrPublisher;
import com.wilson.porcentajewilsontenpo.services.percentage.PercentageInputPort;
import com.wilson.porcentajewilsontenpo.utils.TestDataFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureWebTestClient
class PercentageControllerTest {

    @InjectMocks
    PercentageController percentageController;
    @Mock
    PercentageInputPort percentageInputPort;
    @Mock
    IDdrPublisher iDdrPublisher;

    @Test
    void apiRestOk() {
        when(percentageInputPort.sumaAplicandoPorcentaje(anyString(), anyString(), any()))
                .thenReturn(TestDataFactory.getBasePercentageResponseDto());
        doNothing().when(iDdrPublisher).init(anyString(), anyString(), anyDouble(), anyBoolean(), anyInt(), anyString());
        var response = percentageController.apiRest(TestDataFactory.AUTH,
                TestDataFactory.CLIENT_ID, TestDataFactory.getPercentageRequestDto());
        Assertions.assertEquals(200,response.getStatusCode().value());
    }

    @Test
    void apiRestError() {
        when(percentageInputPort.sumaAplicandoPorcentaje(anyString(), anyString(), any()))
                .thenReturn(TestDataFactory.getBasePercentageResponseDtoNUll());
        var response = percentageController.apiRest(TestDataFactory.AUTH,
                TestDataFactory.CLIENT_ID, TestDataFactory.getPercentageRequestDto());
        Assertions.assertEquals(200,response.getStatusCode().value());
    }

}