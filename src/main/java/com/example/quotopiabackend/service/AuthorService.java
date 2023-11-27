package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoAuthor.AuthorConverter;
import com.example.quotopiabackend.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.model.Author;
import com.example.quotopiabackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorConverter authorConverter;


    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(authorConverter::toAuthorDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(int authorId) {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        return authorOptional.map(authorConverter::toAuthorDTO).orElse(null);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = authorConverter.toAuthorModel(authorDTO);
        author = authorRepository.save(author);
        return authorConverter.toAuthorDTO(author);
    }

    public AuthorDTO updateAuthor(int authorId, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(authorId).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setAuthorName(authorDTO.authorName());
            existingAuthor = authorRepository.save(existingAuthor);
            return authorConverter.toAuthorDTO(existingAuthor);
        }
        return null;
    }

    public boolean deleteAuthor(int authorId) {
        if (authorRepository.existsById(authorId)) {
            authorRepository.deleteById(authorId);
            return true;
        }
        return false;
    }
}



