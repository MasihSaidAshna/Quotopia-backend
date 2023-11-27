package com.example.quotopiabackend.config;

import com.example.quotopiabackend.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.dto.dtoGenre.GenreDTO;
import com.example.quotopiabackend.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.service.AuthorService;
import com.example.quotopiabackend.service.GenreService;
import com.example.quotopiabackend.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private QuoteService quoteService;

    @Override
    public void run(String... args) {
        initializeAuthors();
        initializeGenres();
        initializeQuotes();
    }

    private void initializeAuthors() {
        AuthorDTO author1 = new AuthorDTO(1, "John Doe", null);
        AuthorDTO author2 = new AuthorDTO(2, "Jane Smith", null);

        authorService.createAuthor(author1);
        authorService.createAuthor(author2);
    }

    private void initializeGenres() {
        GenreDTO genre1 = new GenreDTO(1, "Fiction", null);
        GenreDTO genre2 = new GenreDTO(2, "Science Fiction", null);

        genreService.createGenre(genre1);
        genreService.createGenre(genre2);
    }

    private void initializeQuotes() {
        QuoteDTO quote1 = new QuoteDTO(1, "This is a quote.", 1, 1);
        QuoteDTO quote2 = new QuoteDTO(2, "Another quote.", 2, 2);

        quoteService.createQuote(quote1);
        quoteService.createQuote(quote2);
    }


}
