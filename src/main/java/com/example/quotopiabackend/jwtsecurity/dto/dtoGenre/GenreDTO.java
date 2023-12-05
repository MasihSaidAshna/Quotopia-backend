package com.example.quotopiabackend.jwtsecurity.dto.dtoGenre;



import com.example.quotopiabackend.jwtsecurity.dto.dtoSubGenre.SubGenreDTO;

import java.util.List;

public record GenreDTO(int genreID, String genreName, List<SubGenreDTO> subGenreDTOList) {


}
