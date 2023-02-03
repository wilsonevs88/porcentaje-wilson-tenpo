package com.wilson.porcentajewilsontenpo.controller;

import com.wilson.libwilsontenpo.request.PercentageRequestDto;
import com.wilson.libwilsontenpo.response.BasePercentageResponseDto;
import com.wilson.porcentajewilsontenpo.services.PercentageInputPort;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("porcentaje")
public class PercentageController {

    private final PercentageInputPort percentageInputPort;

    @PostMapping("/operacion")
    public ResponseEntity<BasePercentageResponseDto> apiRest(
            @Valid @RequestHeader(value = "api-auth") String xApiAuth,
            @Valid @RequestHeader(value = "client-id") String clientId,
            @Valid @RequestBody PercentageRequestDto request) {
        var operador = percentageInputPort
                .sumaAplicandoPorcentaje(xApiAuth, clientId, request);
        return new ResponseEntity<>(operador, HttpStatus.OK);
    }

}
