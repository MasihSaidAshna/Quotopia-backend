package com.example.quotopiabackend.dto.dtoAuthor;


import com.example.quotopiabackend.dto.dtoQuote.QuoteConverter;
import com.example.quotopiabackend.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                        .map(quoteConverter::toQuoteDTO).collect(Collectors.toList())

        );
    }

    public Author toAuthorModel(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setAuthorID(authorDTO.authorID());
        author.setAuthorName(authorDTO.authorName());
        return author;
    }


}
