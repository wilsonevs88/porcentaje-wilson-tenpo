package com.wilson.porcentajewilsontenpo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PercentageRequestDto {

    private double valueSuma;
    private double porcentaje;

}
