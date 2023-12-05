package com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor;


import com.example.quotopiabackend.jwtsecurity.dto.dtoQuote.QuoteConverter;
import com.example.quotopiabackend.jwtsecurity.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class AuthorConverter {

    @Autowired
    private QuoteConverter quoteConverter;

    public AuthorDTO toAuthorDTO(Author author) {
        return new AuthorDTO(
                author.getAuthorID(),
                author.getAuthorName(),
                author.getQuoteList().stream()
                        .map(quoteConverter::toQuoteDTO)
                        .collect(Collectors.toList())

        );
    }

    public Author toAuthorModel(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setAuthorName(authorDTO.authorName());
        author.setQuoteList(new ArrayList<>());
        return author;
    }


}
