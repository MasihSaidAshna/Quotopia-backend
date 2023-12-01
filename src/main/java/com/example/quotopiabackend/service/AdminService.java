package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoAdmin.AdminConverter;
import com.example.quotopiabackend.dto.dtoAdmin.AdminDTO;
import com.example.quotopiabackend.dto.dtoAdmin.AdminPasswordConverter;
import com.example.quotopiabackend.dto.dtoAdmin.AdminPasswordDTO;
import com.example.quotopiabackend.model.Admin;
import com.example.quotopiabackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminConverter adminConverter;

    @Autowired
    private AdminPasswordConverter adminPasswordConverter;

    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<AdminDTO> admins = adminRepository.findAll().stream()
                .map(adminConverter::toAdminDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    public ResponseEntity<AdminDTO> getAdminById(int adminID) {
        Optional<Admin> admin = adminRepository.findById(adminID);
        return admin.map(value -> new ResponseEntity<>(adminConverter.toAdminDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<AdminDTO> saveAdminWithPassword(AdminPasswordDTO adminPasswordDTO) {
        Admin newAdmin = adminPasswordConverter.toAdminPasswordModel(adminPasswordDTO);
        Admin savedAdmin = adminRepository.save(newAdmin);
        return new ResponseEntity<>(adminConverter.toAdminDTO(savedAdmin), HttpStatus.CREATED);
    }

    public ResponseEntity<AdminDTO> updateAdmin(int adminId, AdminDTO adminDTO) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin existingAdmin = optionalAdmin.get();
            existingAdmin.setAdminName(adminDTO.adminName());
            existingAdmin.setAdminEmail(adminDTO.adminEmail());
            adminRepository.save(existingAdmin);
            return new ResponseEntity<>(adminConverter.toAdminDTO(existingAdmin), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> deleteAdmin(int adminId) {
        if (adminRepository.existsById(adminId)) {
            adminRepository.deleteById(adminId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
