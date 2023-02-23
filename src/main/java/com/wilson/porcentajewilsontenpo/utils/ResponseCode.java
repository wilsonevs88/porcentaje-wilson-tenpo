package com.wilson.porcentajewilsontenpo.utils;

import com.wilson.porcentajewilsontenpo.exception.ExceptionInformation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode implements ExceptionInformation {

    OK(0, "OK", HttpStatus.OK),
    NECESSARY_TO_ENTER_VALUE_ONE(1010, "NECESSARY TO ENTER VALUE ONE", HttpStatus.OK),
    NECESSARY_TO_ENTER_VALUE_TWO(1011, "NECESSARY TO ENTER VALUE TWO", HttpStatus.OK),
    MISSING_ENTER_API_AUTH(1012, "MISSING ENTER API AUTH", HttpStatus.OK),
    MISSING_ENTER_CLIENT_ID(1013, "MISSING ENTER CLIENT ID", HttpStatus.OK),
    MISSING_ENTER_SUM_VALUE(1014, "MISSING ENTER SUM VALUE", HttpStatus.OK),
    MISSING_ENTER_PERCENTAGE_VALUE(1015, "MISSING ENTER PERCENTAGE VALUE", HttpStatus.OK),
    ERROR_OBTAINING_USER_FROM_DATABASE(1017, "ERROR OBTAINING USER FROM DATABASE", HttpStatus.OK),
    ERROR_WHEN_OBTAINING_THE_USER_LIST_FROM_THE_DATABASE(1018, "ERROR WHEN OBTAINING THE USER LIST FROM THE DATABASE", HttpStatus.OK),
    ERROR_WHEN_SAVING_A_DATABASE_USER(1019, "ERROR WHEN SAVING A DATABASE USER", HttpStatus.OK),
    AUTH_ERROR(1023, "AUTH ERROR", HttpStatus.OK),
    ;

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;


    /**
     * Allows to get any exception.
     *
     * @param responseCode Returns the result response.
     */
    public static ExceptionInformation create(ResponseCode responseCode) {
        return new ExceptionInformation() {
            @Override
            public int getCode() {
                return responseCode.getCode();
            }

            @Override
            public String getDescription() {
                return responseCode.getDescription();
            }

            @Override
            public HttpStatus getHttpStatus() {
                return responseCode.getHttpStatus();
            }

        };
    }

}
