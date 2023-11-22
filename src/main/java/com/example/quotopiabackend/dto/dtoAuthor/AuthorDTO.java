package com.example.quotopiabackend.dto.dtoAuthor;


import com.example.quotopiabackend.dto.dtoQuotes.QuotesDTO;

import java.util.List;

public record AuthorDTO(int authorId, String authorName, List<QuotesDTO> quotesListDTO) {

}
