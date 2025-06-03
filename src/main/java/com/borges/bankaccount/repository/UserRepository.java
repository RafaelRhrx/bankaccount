package com.borges.bankaccount.repository;

import com.borges.bankaccount.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
