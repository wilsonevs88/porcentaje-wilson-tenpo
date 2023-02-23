package com.wilson.porcentajewilsontenpo.services.percentage;

import com.wilson.porcentajewilsontenpo.models.BasePercentageResponseDto;
import com.wilson.porcentajewilsontenpo.models.PercentageRequestDto;

public interface PercentageInputPort {

    BasePercentageResponseDto sumaAplicandoPorcentaje(String xApiAuth, String clientId, PercentageRequestDto request);

}
