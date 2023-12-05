package com.example.quotopiabackend.jwtsecurity.dto.dtoAuthor;


import com.example.quotopiabackend.jwtsecurity.dto.dtoQuote.QuoteDTO;

import java.util.List;

public record AuthorDTO(int authorID, String authorName, List<QuoteDTO> quotesListDTO) {

}
