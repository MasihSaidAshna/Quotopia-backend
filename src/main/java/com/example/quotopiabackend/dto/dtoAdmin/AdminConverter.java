package com.example.quotopiabackend.dto.dtoAdmin;

import com.example.quotopiabackend.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {

    public AdminDTO toAdminDTO(Admin admin) {
        return new AdminDTO(admin.getAdminId(), admin.getAdminName(), admin.getAdminEmail());
    }

    public Admin toAdmin(AdminDTO adminDTO) {
        return new Admin(adminDTO.adminId(), adminDTO.adminName(), adminDTO.adminEmail());
    }


}
