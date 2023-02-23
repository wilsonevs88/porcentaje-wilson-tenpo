package com.wilson.porcentajewilsontenpo.ddr;

import com.wilson.porcentajewilsontenpo.entity.UserEntity;
import com.wilson.porcentajewilsontenpo.services.ddrs.UserDdr;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DdrInflater implements IDdrPublisher {

    private final UserDdr userDdr;
    @Value("${city.country}")
    private String cityCountry;
    @Value("${city.utc}")
    private String utc;

    public void init(String action, String clientUuid, double value, boolean state,
                     int responseCode, String responseDescription) {

        UserEntity userEntity = UserEntity.builder()
                .startDate(Timestamp.valueOf(LocalDateTime.now(ZoneId.of(utc))))
                .action(action)
                .clientUuid(clientUuid)
                .value(value)
                .responseCode(responseCode)
                .responseDescription(responseDescription)
                .localDate(Timestamp.valueOf(LocalDateTime.now((ZoneId.of(cityCountry)))))
                .state(state)
                .build();
        userDdr.saveUser(userEntity);
    }

}
