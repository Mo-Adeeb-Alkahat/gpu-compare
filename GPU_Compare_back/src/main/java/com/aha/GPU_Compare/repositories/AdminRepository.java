package com.aha.GPU_Compare.repositories;

import com.aha.GPU_Compare.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,String> {


    Optional<Admin> findByEmail(String email);
}
