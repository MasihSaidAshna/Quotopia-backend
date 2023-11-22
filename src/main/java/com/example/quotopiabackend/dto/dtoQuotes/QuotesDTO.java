package com.example.quotopiabackend.dto.dtoQuotes;


import com.example.quotopiabackend.dto.dtoAuthor.AuthorDTO;
import com.example.quotopiabackend.dto.dtoCategory.CategoryDTO;

public record QuotesDTO(int quotesId, String qouteText, AuthorDTO authorDTO, CategoryDTO categoryDTO) {


}
