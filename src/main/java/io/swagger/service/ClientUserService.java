package io.swagger.service;

import io.swagger.entity.ClientUser;

import java.util.Optional;

public interface ClientUserService {

    Optional<ClientUser> findById(String id);
}
