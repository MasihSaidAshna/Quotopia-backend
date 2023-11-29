package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoGenre.GenreConverter;
import com.example.quotopiabackend.dto.dtoGenre.GenreDTO;
import com.example.quotopiabackend.model.Genre;
import com.example.quotopiabackend.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreConverter genreConverter;

    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream()
                .map(genreConverter::toGenreDTO)
                .collect(Collectors.toList());
    }

    public GenreDTO getGenreById(int genreId) {
        Optional<Genre> genreOptional = genreRepository.findById(genreId);
        return genreOptional.map(genreConverter::toGenreDTO).orElse(null);
    }

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = genreConverter.toGenreModel(genreDTO);
        genre = genreRepository.save(genre);
        return genreConverter.toGenreDTO(genre);
    }

    public GenreDTO updateGenre(int genreId, GenreDTO genreDTO) {
        Genre existingGenre = genreRepository.findById(genreId).orElse(null);
        if (existingGenre != null) {
            // Update existingGenre based on genreDTO
            existingGenre.setGenreName(genreDTO.genreName());
            // Set other fields if needed
            existingGenre = genreRepository.save(existingGenre);
            return genreConverter.toGenreDTO(existingGenre);
        }
        return null; // Genre with given ID not found
    }

    public boolean deleteGenre(int genreId) {
        if (genreRepository.existsById(genreId)) {
            genreRepository.deleteById(genreId);
            return true;
        }
        return false; // Genre with given ID not found
    }
}



