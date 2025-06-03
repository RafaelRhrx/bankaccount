package com.borges.bankaccount.repository;

import com.borges.bankaccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Object> findAllById(Long senderId);
}
