package com.wilson.porcentajewilsontenpo.exception;


import com.wilson.porcentajewilsontenpo.utils.HttpStatus;

public interface ExceptionInformation {

    int getCode();
    String getDescription();
    HttpStatus getHttpStatus();

}
