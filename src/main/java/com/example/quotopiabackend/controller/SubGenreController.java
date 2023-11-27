package com.example.quotopiabackend.controller;


import com.example.quotopiabackend.dto.dtoSubGenre.SubGenreDTO;
import com.example.quotopiabackend.service.SubGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class SubGenreController {

    @Autowired
    private SubGenreService subGenreService;

    @GetMapping
    public ResponseEntity<List<SubGenreDTO>> getAllSubGenre() {
        return ResponseEntity.ok(subGenreService.getAllSubGenres());

    }

    @GetMapping("/{id}")
    public ResponseEntity<SubGenreDTO> getSubGenreById(@PathVariable int id) {
        SubGenreDTO subGenreDTO = subGenreService.getSubGenreById(id);
        return (subGenreDTO != null) ? ResponseEntity.ok(subGenreDTO) : ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<SubGenreDTO> createGenre(@RequestBody SubGenreDTO subGenreDTO) {
        SubGenreDTO createdSubGenre = subGenreService.createSubGenre(subGenreDTO);
        return ResponseEntity.ok(createdSubGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubGenreDTO> updateSubGenre(@PathVariable int id, @RequestBody SubGenreDTO subGenreDTO) {
        SubGenreDTO updatedSubGenre = subGenreService.updateSubGenre(id, subGenreDTO);
        return (updatedSubGenre != null) ? ResponseEntity.ok(updatedSubGenre) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubGenre(@PathVariable int id) {
        boolean deleted = subGenreService.deleteSubGenre(id);
        return (deleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


}


