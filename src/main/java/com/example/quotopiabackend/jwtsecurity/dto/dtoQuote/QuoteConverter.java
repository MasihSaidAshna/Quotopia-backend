package com.example.quotopiabackend.jwtsecurity.dto.dtoQuote;

import com.example.quotopiabackend.jwtsecurity.model.Author;
import com.example.quotopiabackend.jwtsecurity.model.Genre;
import com.example.quotopiabackend.jwtsecurity.model.Quote;
import com.example.quotopiabackend.jwtsecurity.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class QuoteConverter
{

    @Autowired
    AuthorRepository authorRepository;

    public QuoteDTO toQuoteDTO(Quote quote)
    {
        if (quote == null) {
            return null;
        }

        Author author = quote.getAuthor();
        Genre genre = quote.getGenre();

        QuoteDTO.AuthorDTO authorDTO = new QuoteDTO.AuthorDTO(
                author != null ? author.getAuthorID() : 0,
                author != null ? author.getAuthorName() : ""
        );

        QuoteDTO.GenreDTO genreDTO = new QuoteDTO.GenreDTO(
                genre != null ? genre.getGenreID() : 0,
                genre != null ? genre.getGenreName() : ""
        );

        return new QuoteDTO(
                quote.getQuoteID(),
                quote.getQuoteText(),
                authorDTO,
                genreDTO
        );
    }


    public Quote toQuoteModel(QuoteDTO quoteDTO)
    {
        Quote quote = new Quote();
        quote.setQuoteText(quoteDTO.quoteText());

        QuoteDTO.AuthorDTO authorDTO = quoteDTO.author();
        if (authorDTO != null) {
            Author author = authorRepository.findById(authorDTO.authorID()).orElse(null);
            if (author == null) {
                // If author doesn't exist, create a new one and save it
                author = new Author();
                author.setAuthorID(authorDTO.authorID());
                author.setAuthorName(authorDTO.authorName());
                author = authorRepository.save(author);
            }
            quote.setAuthor(author);
        }

        QuoteDTO.GenreDTO genreDTO = quoteDTO.genre();
        if (genreDTO != null) {
            // Similar logic for Genre if needed
        }

        return quote;
    }
}
