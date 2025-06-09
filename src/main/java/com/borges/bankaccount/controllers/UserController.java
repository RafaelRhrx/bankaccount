package com.borges.bankaccount.controllers;

import com.borges.bankaccount.dto.UserDTO;
import com.borges.bankaccount.model.User;
import com.borges.bankaccount.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserDTO dto) {
        User user = userService.registerUser(dto);
        return ResponseEntity.ok(user);
    }
}
