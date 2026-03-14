package com.shark.sharkbank.role.repo;

import com.shark.sharkbank.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
