package com.borges.bankaccount.service;

import com.borges.bankaccount.dto.UserDTO;
import com.borges.bankaccount.model.User;
import com.borges.bankaccount.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserDTO dto) {
        if (userRepository.findByDocument(dto.document()).isPresent()) {
            throw new RuntimeException("CPF/CNPJ já cadastrado");
        }

        User user = new User();
        user.setName(dto.name());
        user.setDocument(dto.document());
        user.setAddress(dto.adress());
        user.setPassword(dto.password());
        user.setType(dto.type());

        return userRepository.save(user);
    }

}