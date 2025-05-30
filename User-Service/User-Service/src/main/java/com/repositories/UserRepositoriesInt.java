package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.User;

@Repository
public interface UserRepositoriesInt extends JpaRepository<User, String> {

}
