package com.example.quotopiabackend.dto.dtoQuote;

import com.example.quotopiabackend.model.Author;
import com.example.quotopiabackend.model.Genre;
import com.example.quotopiabackend.model.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteConverter {

    public QuoteDTO toQuoteDTO(Quote quote) {
        return new QuoteDTO(
                quote.getQuoteID(),
                quote.getQuoteText(),
                quote.getAuthor().getAuthorID(),
                quote.getGenre().getGenreID()
        );

    }

    public Quote toQuoteModel(QuoteDTO quoteDTO, Genre genre, Author author) {
        Quote quote = new Quote();
        quote.setQuoteText(quoteDTO.quoteText());
        quote.setAuthor(author);
        quote.setGenre(genre);
        return quote;
    }
}

