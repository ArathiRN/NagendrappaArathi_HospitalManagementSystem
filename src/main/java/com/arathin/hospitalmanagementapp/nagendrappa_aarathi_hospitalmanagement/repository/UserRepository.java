package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
