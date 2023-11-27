package com.example.quotopiabackend.dto.dtoQuote;

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

    public Quote toQuoteModel(QuoteDTO quoteDTO) {
        Quote quote = new Quote();
        quote.setQuoteID(quoteDTO.quoteID());
        quote.setQuoteText(quoteDTO.quoteText());

        return quote;
    }


}

