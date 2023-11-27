package com.example.quotopiabackend.dto.dtoAdmin;

import com.example.quotopiabackend.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminPasswordConverter {
    public Admin toAdminPasswordModel(AdminPasswordDTO adminPasswordDTO) {
        return new Admin(
                adminPasswordDTO.adminID(),
                adminPasswordDTO.adminName(),
                adminPasswordDTO.adminEmail(),
                adminPasswordDTO.AdminPassword());
    }
}

