package com.example.quotopiabackend.jwtsecurity.dto.dtoQuote;

import com.example.quotopiabackend.jwtsecurity.model.Author;
import com.example.quotopiabackend.jwtsecurity.model.Genre;
import com.example.quotopiabackend.jwtsecurity.model.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteConverter {


    public QuoteDTO toQuoteDTO(Quote quote) {
        int authorID = quote.getAuthor().getAuthorID();
        String authorName = quote.getAuthor().getAuthorName();
        int genreID = quote.getGenre().getGenreID();
        String genreName = quote.getGenre().getGenreName();

        return new QuoteDTO(
                quote.getQuoteID(),
                quote.getQuoteText(),
                new QuoteDTO.AuthorDTO(authorID, authorName),
                new QuoteDTO.GenreDTO(genreID, genreName)
        );
    }


    public Quote toQuoteModel(QuoteDTO quoteDTO) {
        Quote quote = new Quote();
        quote.setQuoteText(quoteDTO.quoteText());

        QuoteDTO.AuthorDTO authorDTO = quoteDTO.author();
        Author author = new Author();
        author.setAuthorID(authorDTO.authorID());
        author.setAuthorName(authorDTO.authorName());
        quote.setAuthor(author);

        QuoteDTO.GenreDTO genreDTO = quoteDTO.genre();
        Genre genre = new Genre();
        genre.setGenreID(genreDTO.genreID());
        genre.setGenreName(genreDTO.genreName());
        quote.setGenre(genre);

        return quote;
    }
}


