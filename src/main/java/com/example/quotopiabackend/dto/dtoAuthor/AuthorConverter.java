package com.example.quotopiabackend.dto.dtoAuthor;


import com.example.quotopiabackend.dto.dtoQuote.QuoteConverter;
import com.example.quotopiabackend.model.Authur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorConverter {

    @Autowired
    private QuoteConverter quoteConverter;

    public AuthorDTO toAuthorDTO(Authur authur) {
        return new AuthorDTO(
                authur.getAuthorID(),
                authur.getAuthorName(),
                authur.getQuoteList().stream()
                        .map(quoteConverter::toQuoteDTO).collect(Collectors.toList())

        );
    }

    public Authur toAuthorModel(AuthorDTO authorDTO) {
        Authur authur = new Authur();
        authur.setAuthorID(authorDTO.authorID());
        authur.setAuthorName(authorDTO.authorName());
        return authur;
    }


}
