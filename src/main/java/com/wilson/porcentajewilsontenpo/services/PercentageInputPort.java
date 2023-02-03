package com.wilson.porcentajewilsontenpo.services;

import com.wilson.libwilsontenpo.request.PercentageRequestDto;
import com.wilson.libwilsontenpo.response.BasePercentageResponseDto;

public interface PercentageInputPort {

    BasePercentageResponseDto sumaAplicandoPorcentaje(String xApiAuth, String clientId, PercentageRequestDto request);

}
