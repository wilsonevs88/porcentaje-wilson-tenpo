package com.wilson.porcentajewilsontenpo.services.impl;

import com.wilson.libwilsontenpo.constante.ResponseCode;
import com.wilson.libwilsontenpo.exception.ExceptionReturn;
import com.wilson.libwilsontenpo.request.PercentageRequestDto;
import com.wilson.libwilsontenpo.response.BasePercentageResponseDto;
import com.wilson.libwilsontenpo.response.PercentageResponseDto;
import com.wilson.porcentajewilsontenpo.services.PercentageInputPort;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PercentageImpl implements PercentageInputPort {

    @Value("${api.auth}")
    private String auth;

    @Override
    public BasePercentageResponseDto sumaAplicandoPorcentaje(
            String xApiAuth,
            String clientId,
            PercentageRequestDto request) {

        try {
            if (!xApiAuth.equals(auth)) {
                return BasePercentageResponseDto.builder()
                        .responseCode(ResponseCode.AUTH_ERROR.getCode())
                        .responseDescription(ResponseCode.AUTH_ERROR.getDescription())
                        .build();
            }
            var response = obtenerPorcentaje(request);
            return BasePercentageResponseDto.builder()
                    .responseCode(ResponseCode.OK.getCode())
                    .responseDescription(ResponseCode.OK.getDescription())
                    .responseContent(PercentageResponseDto.builder()
                            .value(response)
                            .clientUuid(clientId)
                            .build())
                    .build();
        } catch (Exception exception) {
            throw new ExceptionReturn(ResponseCode.CONNECTION_ERROR, exception);
        }

    }

    private static double obtenerPorcentaje(PercentageRequestDto request) {
        var response = (request.getValueSuma() * request.getPorcentaje()) / 100;
        return request.getValueSuma() + response;
    }

}
