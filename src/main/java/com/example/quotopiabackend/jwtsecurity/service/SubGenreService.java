package com.example.quotopiabackend.jwtsecurity.service;

import com.example.quotopiabackend.jwtsecurity.dto.dtoSubGenre.SubGenreDTO;
import com.example.quotopiabackend.jwtsecurity.dto.dtoSubGenre.SubGenreDTOConverter;
import com.example.quotopiabackend.jwtsecurity.model.SubGenre;
import com.example.quotopiabackend.jwtsecurity.repository.SubGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubGenreService {

    @Autowired
    private SubGenreRepository subGenreRepository;

    @Autowired
    private SubGenreDTOConverter subGenreDTOConverter;

    public List<SubGenreDTO> getAllSubGenres() {
        List<SubGenre> subGenres = subGenreRepository.findAll();
        return subGenres.stream()
                .map(subGenreDTOConverter::toSubGenreDTO)
                .collect(Collectors.toList());
    }

    public SubGenreDTO getSubGenreById(int subGenreId) {
        Optional<SubGenre> subGenreOptional = subGenreRepository.findById(subGenreId);
        return subGenreOptional.map(subGenreDTOConverter::toSubGenreDTO).orElse(null);
    }

    public SubGenreDTO createSubGenre(SubGenreDTO subGenreDTO) {
        SubGenre subGenre = subGenreDTOConverter.toSubGenreModel(subGenreDTO);
        subGenre = subGenreRepository.save(subGenre);
        return subGenreDTOConverter.toSubGenreDTO(subGenre);
    }

    public SubGenreDTO updateSubGenre(int subGenreId, SubGenreDTO subGenreDTO) {
        SubGenre existingSubGenre = subGenreRepository.findById(subGenreId).orElse(null);
        if (existingSubGenre != null) {
            existingSubGenre.setSubGenreName(subGenreDTO.subGenreName());
            existingSubGenre = subGenreRepository.save(existingSubGenre);
            return subGenreDTOConverter.toSubGenreDTO(existingSubGenre);
        }
        return null; // SubGenre with given ID not found
    }

    public boolean deleteSubGenre(int subGenreId) {
        if (subGenreRepository.existsById(subGenreId)) {
            subGenreRepository.deleteById(subGenreId);
            return true;
        }
        return false;
    }

}


