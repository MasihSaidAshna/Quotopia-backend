package com.example.quotopiabackend.jwtsecurity.config;

import com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.jwtsecurity.dto.dtoGenre.GenreDTO;
import com.example.quotopiabackend.jwtsecurity.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.jwtsecurity.dto.dtoSubGenre.SubGenreDTO;
import com.example.quotopiabackend.jwtsecurity.service.AuthorService;
import com.example.quotopiabackend.jwtsecurity.service.GenreService;
import com.example.quotopiabackend.jwtsecurity.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;


    @Override
    public void run(String... args) {
        AuthorDTO author1 = createAuthor("John Doe", new ArrayList<>());
        AuthorDTO author2 = createAuthor("Jane Smith", new ArrayList<>());
        AuthorDTO author3 = createAuthor("Cihad Özdemir", new ArrayList<>());
        AuthorDTO author4 = createAuthor("Cristiano Ronaldo", new ArrayList<>());

        GenreDTO genre1 = createGenre("Fiction", new ArrayList<>());
        GenreDTO genre2 = createGenre("Science Fiction", new ArrayList<>());
        GenreDTO genre3 = createGenre("Science", new ArrayList<>());
        GenreDTO genre4 = createGenre("Sport", new ArrayList<>());
        GenreDTO genre5 = createGenre("GoldenAdvice", new ArrayList<>());

        createQuote("This is a quote.", author1, genre1);
        createQuote("Another quote.", author2, genre2);
        createQuote("Just finish school and make money", author3, genre3);
        createQuote("life dont care about you, make something out of it then", author3, genre5);
        createQuote("people want to do something with their life, i just want to live", author3, genre5);
        createQuote("always stay independent less headache", author3, genre5);
        createQuote("just do as you wish, i will end on top", author3, genre5);
        createQuote("I don't mind people hating me, because it pushes me.", author4, genre4);
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
        QuoteDTO.AuthorDTO authorDTO = new QuoteDTO.AuthorDTO(author.authorID(), author.authorName());
        QuoteDTO.GenreDTO genreDTO = new QuoteDTO.GenreDTO(genre.genreID(), genre.genreName());

        QuoteDTO quoteDTO = new QuoteDTO(-1, quote, authorDTO, genreDTO);

        quoteService.createQuote(quoteDTO);
    }
}*/

