package com.example.quotopiabackend.dto.dtoAuthor;


import com.example.quotopiabackend.dto.dtoQuote.QuoteDTO;

import java.util.List;

public record AuthorDTO(int authorID, String authorName, List<QuoteDTO> quotesListDTO) {

}
