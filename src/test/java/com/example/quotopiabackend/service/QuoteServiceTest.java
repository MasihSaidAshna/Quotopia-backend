package com.example.quotopiabackend.service;


import com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor.AuthorConverter;
import com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.jwtsecurity.dto.dtoGenre.GenreConverter;
import com.example.quotopiabackend.jwtsecurity.dto.dtoGenre.GenreDTO;
import com.example.quotopiabackend.jwtsecurity.dto.dtoQuote.*;
import com.example.quotopiabackend.jwtsecurity.model.*;
import com.example.quotopiabackend.jwtsecurity.repository.QuoteRepository;
import com.example.quotopiabackend.jwtsecurity.service.QuoteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class QuoteServiceTest {

    //@Mock
    //QuoteRepository quoteRepository;
    @Autowired
    private QuoteService quoteService;
    private QuoteConverter quoteConverter;

    //private AuthorConverter authorConverter;

    //private GenreConverter genreConverter;

    @BeforeAll
    public void setup() {
        List<Quote> authorQuotes = new ArrayList<>();
        List<SubGenre> subgenres = new ArrayList<>();
        Author author = new Author(1, "Stephen Hawking", authorQuotes);
        Genre genre = new Genre(1, "Fiction", subgenres);
        Quote quote = new Quote(1, "This is a test", author, genre);
        QuoteDTO quoteDTO = quoteConverter.toQuoteDTO(quote);
        //AuthorDTO authorDTO = authorConverter.toAuthorDTO(author);
        //GenreDTO genreDTO = genreConverter.toGenreDTO(genre);
        //QuoteDTO.AuthorDTO authorDTO1 = new QuoteDTO.AuthorDTO(1, "Stephen Hawking");
        //QuoteDTO.GenreDTO genreDTO1 = new QuoteDTO.GenreDTO(1, "Science Fiction");

        quoteService.createQuote(quoteDTO);
    }


    @Test
    @Order(1)
    public void getAllQuotesTest() { //Dto converters bliver ikke testet fordi der er noget med at QuoteDTO har 2 record klasser inden i sig.
        List<Quote> authorQuotes = new ArrayList<>();
        List<SubGenre> subgenres = new ArrayList<>();
        Author author = new Author(1, "Stephen Hawking", authorQuotes);
        Genre genre = new Genre(1, "Fiction", subgenres);
        Quote quote = new Quote(1, "This is a test", author, genre);
        QuoteDTO quoteDTO = quoteConverter.toQuoteDTO(quote);

        List<QuoteDTO> quotesTest = new ArrayList<>();
        quotesTest.add(quoteDTO);

        assertEquals(quotesTest, quoteService.getAllQuotes());
    }


    @Test
    @Order(2)
    public void getQuoteByIdTest() {
        assertEquals(quoteService.getQuoteById(1).quoteText(), "This is a test");
    }

    @Test
    @Order(3)
    public void updateQuoteTest() {
        List<Quote> authorQuotes = new ArrayList<>();
        List<SubGenre> subgenres = new ArrayList<>();
        Author author = new Author(1, "Stephen Hawking", authorQuotes);
        Genre genre = new Genre(1, "Fiction", subgenres);
        Quote quote = new Quote(1, "This is an UPDATED test", author, genre);
        QuoteDTO quoteDTO = quoteConverter.toQuoteDTO(quote);
        quoteService.updateQuote(1, quoteDTO);

        assertEquals(quoteService.getQuoteById(1).quoteText(), "This is an UPDATED test");
    }

    @Test
    @Order(4)
    public void deleteQuoteTest() {
        quoteService.deleteQuote(1);
        assertNull(quoteService.getQuoteById(1));
    }

}
