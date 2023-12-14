package com.example.quotopiabackend.jwtsecurity.controller;


import com.example.quotopiabackend.jwtsecurity.dto.dtoGenre.GenreDTO;
import com.example.quotopiabackend.jwtsecurity.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;


/*    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());

    }*/

    @GetMapping()
    public ResponseEntity<Page<GenreDTO>> getAllGenres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "genreName") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return ResponseEntity.ok(genreService.getAllGenres(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenreByID(@PathVariable int id) {
        GenreDTO genreDTO = genreService.getGenreById(id);
        return (genreDTO != null) ? ResponseEntity.ok(genreDTO) : ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genreDTO) {
        GenreDTO createdGenre = genreService.createGenre(genreDTO);
        return ResponseEntity.ok(createdGenre);
    }

    //todo forbehold til admin
    @PutMapping("/{id}")
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


