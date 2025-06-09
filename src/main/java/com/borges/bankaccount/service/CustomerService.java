package com.borges.bankaccount.service;

import com.borges.bankaccount.dto.CustomerDTO;
import com.borges.bankaccount.model.Customer;
import com.borges.bankaccount.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerUser(CustomerDTO dto) {
        if (customerRepository.findByDocument(dto.document()).isPresent()) {
            throw new RuntimeException("CPF/CNPJ já cadastrado");
        }

        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setDocument(dto.document());
        customer.setAddress(dto.address());
        customer.setPassword(dto.password());
        customer.setType(dto.type());

        return customerRepository.save(customer);
    }

}