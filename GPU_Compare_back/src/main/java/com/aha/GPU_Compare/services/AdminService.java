package com.aha.GPU_Compare.services;

import com.aha.GPU_Compare.models.Admin;
import com.aha.GPU_Compare.repositories.AdminRepository;

import java.util.Optional;

public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin getByEmail(String email) {
        Optional<Admin> admin = this.adminRepository.findByEmail(email);

        if(admin.isPresent())
            return admin.get();

        return null;
    }
}
