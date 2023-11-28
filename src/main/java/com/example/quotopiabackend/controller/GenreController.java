package com.example.quotopiabackend.controller;


import com.example.quotopiabackend.dto.dtoGenre.GenreDTO;
import com.example.quotopiabackend.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());

    }

    @GetMapping("/{id)")
    public ResponseEntity<GenreDTO> getGenreByID(@PathVariable int id) {
        GenreDTO genreDTO = genreService.getGenreById(id);
        return (genreDTO != null) ? ResponseEntity.ok(genreDTO) : ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genreDTO) {
        GenreDTO createdGenre = genreService.createGenre(genreDTO);
        return ResponseEntity.ok(createdGenre);
    }

    @PutMapping("/{id)")
    public ResponseEntity<GenreDTO> createGenre(@PathVariable int id, @RequestBody GenreDTO genreDTO) {
        GenreDTO updatedGenre = genreService.updateGenre(id, genreDTO);
        return (updatedGenre != null) ? ResponseEntity.ok(updatedGenre) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable int id) {
        boolean deleted = genreService.deleteGenre(id);
        return (deleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}


