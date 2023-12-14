package com.example.quotopiabackend.jwtsecurity.controller;

import com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.jwtsecurity.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;



/*    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }*/

    @GetMapping()
    public ResponseEntity<Page<AuthorDTO>> getAllAuthors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "authorName") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return ResponseEntity.ok(authorService.getAllAuthors(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable int id) {
        AuthorDTO authorDTO = authorService.getAuthorById(id);
        return (authorDTO != null) ? ResponseEntity.ok(authorDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO createdAuthor = authorService.createAuthor(authorDTO);
        return ResponseEntity.ok(createdAuthor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable int id, @RequestBody AuthorDTO authorDTO) {
        AuthorDTO updatedAuthor = authorService.updateAuthor(id, authorDTO);
        return (updatedAuthor != null) ? ResponseEntity.ok(updatedAuthor) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        boolean deleted = authorService.deleteAuthor(id);
        return (deleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}


