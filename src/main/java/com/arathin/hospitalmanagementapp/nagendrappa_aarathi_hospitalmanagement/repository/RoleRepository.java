package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository;


import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

