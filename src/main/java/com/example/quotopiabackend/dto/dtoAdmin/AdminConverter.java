package com.example.quotopiabackend.dto.dtoAdmin;

import com.example.quotopiabackend.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {

    public AdminDTO toAdminDTO(Admin admin) {
        return new AdminDTO(
                admin.getAdminID(),
                admin.getAdminName(),
                admin.getAdminEmail());
    }

    public Admin toAdminModel(AdminDTO adminDTO) {
        return new Admin(
                adminDTO.adminID(),
                adminDTO.adminName(),
                adminDTO.adminEmail());
    }


}
