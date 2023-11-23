package com.example.quotopiabackend.dto.dtoGenre;

import com.example.quotopiabackend.dto.dtoSubCategory.SubGenreDTOConverter;
import com.example.quotopiabackend.dto.dtoSubCategory.SubGenreDTO;
import com.example.quotopiabackend.model.Genre;
import com.example.quotopiabackend.model.SubGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GenreConverter {

    @Autowired
    private SubGenreDTOConverter subGenreDTOConverter;

    public GenreDTO toCategoryDTO(Genre genre) {
        return new GenreDTO(
                genre.getGenreID(),
                genre.getGenreName(),
                genre.getSubGenres().stream().map(subGenreDTOConverter::toSubGenreDTO).collect(Collectors.toList())

        );

    }


    public SubGenre toUnderCategoryEntity(SubGenreDTO subGenreDTO) {
        SubGenre subGenre = new SubGenre();
        subGenre.setSubGenreName(subGenreDTO.subGenreName());
        subGenre.setSubGenreID(subGenreDTO.subGenreID());

        return subGenre;
    }


}




