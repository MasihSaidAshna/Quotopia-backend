package com.example.quotopiabackend.dto.dtoAuthor;

import dat3.server_to_server.dto.dtoQuotes.QuotesDTO;

import java.util.List;

public record AuthorDTO(int authorId, String authorName, List<QuotesDTO> quotesListDTO) {

}
