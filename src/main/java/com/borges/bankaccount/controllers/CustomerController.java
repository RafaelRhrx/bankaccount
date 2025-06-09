package com.borges.bankaccount.controllers;

import com.borges.bankaccount.dto.CustomerDTO;
import com.borges.bankaccount.model.Customer;
import com.borges.bankaccount.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> register(@RequestBody CustomerDTO dto) {
        Customer customer = customerService.registerUser(dto);
        return ResponseEntity.ok(customer);
    }
}
