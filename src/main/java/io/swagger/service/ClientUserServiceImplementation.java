package io.swagger.service;

import io.swagger.entity.ClientUser;
import io.swagger.repository.ClientUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientUserServiceImplementation implements ClientUserService {

    @Autowired
    private ClientUserRepository clientUserRepository;

    @Override
    public Optional<ClientUser> findById(String id) {
        return clientUserRepository.findById(id);
    }
}
