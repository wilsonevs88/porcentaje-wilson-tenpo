package com.wilson.porcentajewilsontenpo.repository;

import com.wilson.porcentajewilsontenpo.entity.UserEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findAll(Pageable pageable);

    Optional<UserEntity> findById(Long userId);

    List<UserEntity> findByState(boolean state);

    List<UserEntity> findByClientUuid(String clientUuid);

    List<UserEntity> findByActionAndClientUuidAndState(String action, String clientUuid, boolean state);

    Page<UserEntity> findAllByClientUuid(String clientUuid, Pageable pageable);

}