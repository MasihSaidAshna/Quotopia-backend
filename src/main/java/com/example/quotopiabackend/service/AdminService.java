package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoAdmin.AdminDTO;
import com.example.quotopiabackend.dto.dtoAdmin.AdminPasswordDTO;
import com.example.quotopiabackend.model.Admin;
import com.example.quotopiabackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> getAdminById(int adminID) {
        return adminRepository.findById(adminID);
    }

    public Admin saveAdmin(AdminDTO adminDTO) {
        Admin newAdmin = new Admin();
        newAdmin.setAdminName(adminDTO.adminName());
        newAdmin.setAdminEmail(adminDTO.adminEmail());
        return adminRepository.save(newAdmin);
    }

    public Admin saveAdminWithPassword(AdminPasswordDTO adminPasswordDTO) {
        Admin newAdmin = new Admin();
        newAdmin.setAdminName(adminPasswordDTO.adminName());
        newAdmin.setAdminEmail(adminPasswordDTO.adminEmail());
        newAdmin.setAdminPassword(adminPasswordDTO.AdminPassword());
        return adminRepository.save(newAdmin);
    }

    public Admin updateAdmin(int adminId, AdminDTO adminDTO) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin existingAdmin = optionalAdmin.get();
            existingAdmin.setAdminName(adminDTO.adminName());
            existingAdmin.setAdminEmail(adminDTO.adminEmail());
            return adminRepository.save(existingAdmin);
        }
        return null;
    }

    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(admin -> new AdminDTO(admin.getAdminID(), admin.getAdminName(), admin.getAdminEmail()))
                .collect(Collectors.toList());
    }

    public Optional<Admin> getAdminById(int adminID) {
        return adminRepository.findById(adminID);
    }

    public Admin saveAdmin(AdminDTO adminDTO) {
        Admin newAdmin = new Admin();
        newAdmin.setAdminName(adminDTO.adminName());
        newAdmin.setAdminEmail(adminDTO.adminEmail());
        return adminRepository.save(newAdmin);

    }

    public Admin saveAdminWithPassword(AdminPasswordDTO adminPasswordDTO) {
        Admin newAdmin = new Admin();
        newAdmin.setAdminName(adminPasswordDTO.adminName());
        newAdmin.setAdminEmail(adminPasswordDTO.adminEmail());
        newAdmin.setAdminPassword(adminPasswordDTO.AdminPassword());
        return adminRepository.save(newAdmin);

    }

    public Admin updateAdmin(int adminId, AdminDTO adminDTO) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin existingAdmin = optionalAdmin.get();
            existingAdmin.setAdminName(adminDTO.adminName());
            existingAdmin.setAdminEmail(adminDTO.adminEmail());
            return adminRepository.save(existingAdmin);
        }
        return null;
    }

    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(admin -> new AdminDTO(admin.getAdminID(), admin.getAdminName(), admin.getAdminEmail()))
                .collect(Collectors.toList());
    }
}
