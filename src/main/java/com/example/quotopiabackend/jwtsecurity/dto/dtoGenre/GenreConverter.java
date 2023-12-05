package com.example.quotopiabackend.jwtsecurity.dto.dtoGenre;

import com.example.quotopiabackend.jwtsecurity.dto.dtoSubGenre.SubGenreDTO;
import com.example.quotopiabackend.jwtsecurity.dto.dtoSubGenre.SubGenreDTOConverter;
import com.example.quotopiabackend.jwtsecurity.model.Genre;
import com.example.quotopiabackend.jwtsecurity.model.SubGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreConverter {

    @Autowired
    private SubGenreDTOConverter subGenreDTOConverter;

    public GenreDTO toGenreDTO(Genre genre) {
        return new GenreDTO(
                genre.getGenreID(),
                genre.getGenreName(),
                genre.getSubGenres().stream().map(subGenreDTOConverter::toSubGenreDTO).collect(Collectors.toList())

        );

    }


    public Genre toGenreModel(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setGenreName(genreDTO.genreName());

        List<SubGenreDTO> subGenreDTOList = genreDTO.subGenreDTOList();
        if (subGenreDTOList != null) {
            List<SubGenre> subGenres = subGenreDTOList.stream().map(subGenreDTOConverter::toSubGenreModel).collect(Collectors.toList());
            genre.setSubGenres(subGenres);
        }

        return genre;
    }

}




