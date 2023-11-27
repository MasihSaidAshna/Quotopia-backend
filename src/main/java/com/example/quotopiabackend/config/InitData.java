package com.example.quotopiabackend.config;

import com.example.quotopiabackend.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.dto.dtoGenre.GenreDTO;
import com.example.quotopiabackend.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.dto.dtoSubGenre.SubGenreDTO;
import com.example.quotopiabackend.service.AuthorService;
import com.example.quotopiabackend.service.GenreService;
import com.example.quotopiabackend.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        AuthorDTO author1 = createAuthor("John Doe", new ArrayList<>());
        AuthorDTO author2 = createAuthor("Jane Smith", new ArrayList<>());

        GenreDTO genre1 = createGenre("Fiction", new ArrayList<>());
        GenreDTO genre2 = createGenre("Science Fiction", new ArrayList<>());

        createQuote("This is a quote.", author1, genre1);
        createQuote("Another quote.", author2, genre2);
    }

    private AuthorDTO createAuthor(String name, List<QuoteDTO> quotes) {
        AuthorDTO author = new AuthorDTO(0, name, quotes);
        return authorService.createAuthor(author);
    }

    private GenreDTO createGenre(String name, List<SubGenreDTO> subGenres) {
        GenreDTO genre = new GenreDTO(-1, name, subGenres);

        return genreService.createGenre(genre);
    }

    private void createQuote(String quote, AuthorDTO author, GenreDTO genre) {
        QuoteDTO quote1 = new QuoteDTO(-1, quote, author.authorID(), genre.genreID());

        quoteService.createQuote(quote1);
    }


}




