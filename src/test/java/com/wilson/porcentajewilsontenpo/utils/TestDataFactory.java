package com.wilson.porcentajewilsontenpo.utils;


import com.wilson.porcentajewilsontenpo.models.BasePercentageResponseDto;
import com.wilson.porcentajewilsontenpo.models.PercentageRequestDto;
import com.wilson.porcentajewilsontenpo.models.PercentageResponseDto;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.domain.PageRequest;

public class TestDataFactory {

    public static final String AUTH = "wilson3042258679";
    public static final String USER_ID = "user_wilso_tenpo";
    public static final String CLIENT_ID = "uuid_wilso_tenpo";
    public static final Integer CODE_OK = 0;
    public static final Integer CODE_ERROR = 99;
    public static final Integer CODE_ERROR_1023 = 1023;
    public static final String DESCRIPTION_OK = "OK";
    public static final String DESCRIPTION_ERROR = "ERROR";
    public static final Integer RESPONSE_CODE_TEST = 5000;
    public static final Integer PAGE = 1;
    public static final Integer SIZE = 1;
    public static final Long ID_LONG = 1L;
    public static String ACTION_GET = "GET";
    public static double VALUE = 34.5;
    public static Integer RETRY = 0;
    public static boolean STATE = Boolean.TRUE;
    public static Long TIME_OUT_MINUTES = 1l;
    public static Date fechaActual = new Date();
    public static Timestamp START_DATE = new Timestamp(fechaActual.getTime());
    public static String EXPIRATION = "1";


    public static PageRequest getPageRequest() {
        return PageRequest.of(TestDataFactory.PAGE, TestDataFactory.SIZE);
    }


    public static BasePercentageResponseDto getBasePercentageResponseDto() {
        return BasePercentageResponseDto.builder()
                .responseCode(CODE_ERROR)
                .responseDescription(DESCRIPTION_ERROR)
                .responseContent(getPercentageResponseDto())
                .build();
    }

    public static BasePercentageResponseDto getBasePercentageResponseDtoNUll() {
        return BasePercentageResponseDto.builder()
                .responseCode(CODE_ERROR)
                .responseDescription(DESCRIPTION_ERROR)
                .build();
    }

    public static BasePercentageResponseDto getBasePercentageResponseDto1023() {
        return BasePercentageResponseDto.builder()
                .responseCode(CODE_ERROR_1023)
                .responseDescription(DESCRIPTION_ERROR)
                .responseContent(getPercentageResponseDto())
                .build();
    }

    public static PercentageResponseDto getPercentageResponseDto() {
        return PercentageResponseDto.builder()
                .clientUuid(CLIENT_ID)
                .value(VALUE)
                .status(STATE)
                .build();
    }

    public static PercentageRequestDto getPercentageRequestDto() {
        return PercentageRequestDto.builder()
                .valueSuma(VALUE)
                .porcentaje(VALUE)
                .build();
    }

    public static PercentageRequestDto getPercentageRequestDtoMenorSuma() {
        return PercentageRequestDto.builder()
                .valueSuma(-2)
                .porcentaje(VALUE)
                .build();
    }

    public static PercentageRequestDto getPercentageRequestDtoPorcenatjeMenor() {
        return PercentageRequestDto.builder()
                .valueSuma(VALUE)
                .porcentaje(-2)
                .build();
    }

}
