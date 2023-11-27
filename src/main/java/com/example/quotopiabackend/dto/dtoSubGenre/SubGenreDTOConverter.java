package com.example.quotopiabackend.dto.dtoSubGenre;

import com.example.quotopiabackend.model.SubGenre;
import org.springframework.stereotype.Component;

@Component
public class SubGenreDTOConverter {


    public SubGenreDTO toSubGenreDTO(SubGenre subGenre) {
        return new SubGenreDTO(
                subGenre.getSubGenreID(),
                subGenre.getSubGenreName(),
                subGenre.getGenre().getGenreID()

        );
    }

    public SubGenre toSubGenreModel(SubGenreDTO subGenreDTO) {
        SubGenre subGenre = new SubGenre();
        subGenre.setSubGenreID(subGenreDTO.subGenreID());
        subGenre.setSubGenreName(subGenreDTO.subGenreName());

        return subGenre;
    }






}
