package com.wilson.porcentajewilsontenpo.services.percentage.impl;

import com.wilson.porcentajewilsontenpo.models.BasePercentageResponseDto;
import com.wilson.porcentajewilsontenpo.models.PercentageRequestDto;
import com.wilson.porcentajewilsontenpo.models.PercentageResponseDto;
import com.wilson.porcentajewilsontenpo.services.percentage.PercentageInputPort;
import com.wilson.porcentajewilsontenpo.utils.ResponseCode;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PercentageImpl implements PercentageInputPort {

    @Value("${api.auth_percentage}")
    private String auth;

    @Override
    public BasePercentageResponseDto sumaAplicandoPorcentaje(String xApiAuth, String clientId, PercentageRequestDto request) {

        if (StringUtils.isBlank(xApiAuth)) {
            return BasePercentageResponseDto.builder()
                    .responseCode(ResponseCode.MISSING_ENTER_API_AUTH.getCode())
                    .responseDescription(ResponseCode.MISSING_ENTER_API_AUTH.getDescription())
                    .build();
        }

        if (StringUtils.isBlank(clientId)) {
            return BasePercentageResponseDto.builder()
                    .responseCode(ResponseCode.MISSING_ENTER_CLIENT_ID.getCode())
                    .responseDescription(ResponseCode.MISSING_ENTER_CLIENT_ID.getDescription())
                    .build();
        }

        if (request.getValueSuma() < 0) {
            return BasePercentageResponseDto.builder()
                    .responseCode(ResponseCode.MISSING_ENTER_SUM_VALUE.getCode())
                    .responseDescription(ResponseCode.MISSING_ENTER_SUM_VALUE.getDescription())
                    .build();
        }

        if (request.getPorcentaje() < 0) {
            return BasePercentageResponseDto.builder()
                    .responseCode(ResponseCode.MISSING_ENTER_PERCENTAGE_VALUE.getCode())
                    .responseDescription(ResponseCode.MISSING_ENTER_PERCENTAGE_VALUE.getDescription())
                    .build();
        }

        if (xApiAuth.equals(auth)) {
            var percentage = getPercentage(request);
            var response = getDecimal(percentage);
            var base = BasePercentageResponseDto.builder()
                    .responseCode(ResponseCode.OK.getCode())
                    .responseDescription(ResponseCode.OK.getDescription())
                    .responseContent(PercentageResponseDto.builder()
                            .value(response)
                            .clientUuid(clientId)
                            .status(false)
                            .build())
                    .build();
            return base;
        } else {
            return BasePercentageResponseDto.builder()
                    .responseCode(ResponseCode.AUTH_ERROR.getCode())
                    .responseDescription(ResponseCode.AUTH_ERROR.getDescription())
                    .build();
        }

    }

    private static Double getDecimal(double request) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        var response = df.format(request);
        return Double.valueOf(response);
    }

    private static double getPercentage(PercentageRequestDto request) {
        var response = (request.getValueSuma() * request.getPorcentaje()) / 100;
        return request.getValueSuma() + response;
    }

}
