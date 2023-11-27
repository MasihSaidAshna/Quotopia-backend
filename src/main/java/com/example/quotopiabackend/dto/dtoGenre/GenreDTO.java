package com.example.quotopiabackend.dto.dtoGenre;


import com.example.quotopiabackend.dto.dtoSubGenre.SubGenreDTO;

import java.util.List;

public record GenreDTO(int genreID, String genreName, List<SubGenreDTO> subGenreDTOList) {


}
