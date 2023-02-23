package com.wilson.porcentajewilsontenpo.controller;

import com.wilson.porcentajewilsontenpo.ddr.IDdrPublisher;
import com.wilson.porcentajewilsontenpo.models.BasePercentageResponseDto;
import com.wilson.porcentajewilsontenpo.models.PercentageRequestDto;
import com.wilson.porcentajewilsontenpo.services.percentage.PercentageInputPort;
import com.wilson.porcentajewilsontenpo.utils.Constants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("porcentaje")
public class PercentageController {

    private final PercentageInputPort percentageInputPort;
    private final IDdrPublisher iDdrPublisher;

    @PostMapping(value = "/operacion/",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasePercentageResponseDto> apiRest(
            @RequestHeader(value = "api-auth", required = false) String xApiAuth,
            @RequestParam(value = "client-id", required = false) String clientId,
            @RequestBody PercentageRequestDto request) {
        log.info("Starting percentage...");
        var response = percentageInputPort
                .sumaAplicandoPorcentaje(xApiAuth, clientId, request);

        if (response.getResponseContent() != null) {
            iDdrPublisher.init(Constants.ACTION_PORCENTAGE, response.getResponseContent().getClientUuid(),
                    response.getResponseContent().getValue(), response.getResponseContent().isStatus(),
                    response.getResponseCode(), response.getResponseDescription());
        } else {
            iDdrPublisher.init(Constants.ACTION_PORCENTAGE, null, 0, Boolean.FALSE,
                    response.getResponseCode(), response.getResponseDescription());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
