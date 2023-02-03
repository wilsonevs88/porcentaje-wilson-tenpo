package com.wilson.porcentajewilsontenpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
public class PorcentajeWilsonTenpoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PorcentajeWilsonTenpoApplication.class, args);
    }

}
