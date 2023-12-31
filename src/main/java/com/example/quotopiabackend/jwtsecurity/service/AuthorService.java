package com.example.quotopiabackend.jwtsecurity.service;

import com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor.AuthorConverter;
import com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.jwtsecurity.model.Author;
import com.example.quotopiabackend.jwtsecurity.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorConverter authorConverter;

/*    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(authorConverter::toAuthorDTO)
                .collect(Collectors.toList());
    }*/

    public Page<AuthorDTO> getAllAuthors(Pageable pageable) {
        Page<Author> authorPage = authorRepository.findAll(pageable);
        return authorPage.map(authorConverter::toAuthorDTO);
    }


    public AuthorDTO getAuthorById(int authorID) {
        Optional<Author> authorOptional = authorRepository.findById(authorID);
        return authorOptional.map(authorConverter::toAuthorDTO).orElse(null);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = authorConverter.toAuthorModel(authorDTO);
        author = authorRepository.save(author);
        return authorConverter.toAuthorDTO(author);
    }


    public AuthorDTO updateAuthor(int authorID, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(authorID).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setAuthorName(authorDTO.authorName());
            existingAuthor = authorRepository.save(existingAuthor);
            return authorConverter.toAuthorDTO(existingAuthor);
        }
        return null;
    }

    public boolean deleteAuthor(int authorID) {
        if (authorRepository.existsById(authorID)) {
            authorRepository.deleteById(authorID);
            return true;
        }
        return false;
    }

}





