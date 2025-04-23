package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.User;

public interface UserRepositoriesInt extends JpaRepository<User, String> {

}
