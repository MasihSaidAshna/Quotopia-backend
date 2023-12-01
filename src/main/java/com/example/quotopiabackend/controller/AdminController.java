package com.example.quotopiabackend.controller;

import com.example.quotopiabackend.dto.dtoAdmin.AdminDTO;
import com.example.quotopiabackend.dto.dtoAdmin.AdminPasswordDTO;
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


    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/saveWithPassword")
    public ResponseEntity<AdminDTO> saveAdminWithPassword(@RequestBody AdminPasswordDTO adminPasswordDTO) {
        return adminService.saveAdminWithPassword(adminPasswordDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AdminDTO> updateAdmin(@PathVariable int id, @RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(id, adminDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
        return adminService.deleteAdmin(id);
    }

}
