package com.example.quotopiabackend.controller;

import com.example.quotopiabackend.dto.dtoAdmin.AdminDTO;
import com.example.quotopiabackend.dto.dtoAdmin.AdminPasswordDTO;
import com.example.quotopiabackend.model.Admin;
import com.example.quotopiabackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody AdminDTO adminDTO) {
        Admin savedAdmin = adminService.saveAdmin(adminDTO);
        return ResponseEntity.ok(savedAdmin);
    }

    @PostMapping("/save-with-password")
    public ResponseEntity<Admin> saveAdminWithPassword(@RequestBody AdminPasswordDTO adminPasswordDTO) {
        Admin savedAdmin = adminService.saveAdminWithPassword(adminPasswordDTO);
        return ResponseEntity.ok(savedAdmin);
    }

    @PutMapping("/update/{adminID}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int adminId, @RequestBody AdminDTO adminDTO) {
        Admin updatedAdmin = adminService.updateAdmin(adminId, adminDTO);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<AdminDTO> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }


}
