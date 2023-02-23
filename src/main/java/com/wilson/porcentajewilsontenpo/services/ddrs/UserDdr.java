package com.wilson.porcentajewilsontenpo.services.ddrs;

import com.wilson.porcentajewilsontenpo.entity.UserEntity;

import java.util.List;

import org.springframework.data.domain.Page;

public interface UserDdr {

    UserEntity getUserId(Long userId);
    List<UserEntity> getState(boolean state);

    List<UserEntity> getClientUuid(String clientUuid);

    Page<UserEntity> completeSearch(Integer page, Integer size);

    List<UserEntity> getClientActionAndClientUuidAndState(String action, String clientUuid, boolean state);

    Page<UserEntity> listSearchByClientUuid(String clientUuid, Integer page, Integer size);

    void saveUser(UserEntity user);

}
