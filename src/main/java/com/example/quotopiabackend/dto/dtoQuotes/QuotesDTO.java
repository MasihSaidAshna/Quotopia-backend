package com.example.quotopiabackend.dto.dtoQuotes;

import dat3.server_to_server.dto.dtoAuthor.AuthorDTO;
import dat3.server_to_server.dto.dtoCategory.CategoryDTO;


public record QuotesDTO(int quotesId, String qouteText, AuthorDTO authorDTO, CategoryDTO categoryDTO) {


}
