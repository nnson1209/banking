package com.shark.sharkbank.auth_users.repo;

import com.shark.sharkbank.auth_users.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
