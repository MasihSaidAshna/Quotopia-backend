package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoQuote.QuoteConverter;
import com.example.quotopiabackend.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.model.Author;
import com.example.quotopiabackend.model.Genre;
import com.example.quotopiabackend.model.Quote;
import com.example.quotopiabackend.repository.AuthorRepository;
import com.example.quotopiabackend.repository.GenreRepository;
import com.example.quotopiabackend.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private QuoteConverter quoteConverter;

    public List<QuoteDTO> getAllQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.stream()
                .map(quoteConverter::toQuoteDTO)
                .collect(Collectors.toList());
    }

    public QuoteDTO getQuoteById(int quoteId) {
        Optional<Quote> quoteOptional = quoteRepository.findById(quoteId);
        return quoteOptional.map(quoteConverter::toQuoteDTO).orElse(null);
    }


    public QuoteDTO updateQuote(int quoteId, QuoteDTO quoteDTO) {
        Quote existingQuote = quoteRepository.findById(quoteId).orElse(null);
        if (existingQuote != null) {
            // Update existingQuote based on quoteDTO
            existingQuote.setQuoteText(quoteDTO.quoteText());
            // Set other fields if needed
            existingQuote = quoteRepository.save(existingQuote);
            return quoteConverter.toQuoteDTO(existingQuote);
        }
        return null; // Quote with given ID not found
    }

    public boolean deleteQuote(int quoteId) {
        if (quoteRepository.existsById(quoteId)) {
            quoteRepository.deleteById(quoteId);
            return true;
        }
        return false; // Quote with given ID not found
    }
    public QuoteDTO createQuote(QuoteDTO quoteDTO) {
        Quote quote = quoteConverter.toQuoteModel(quoteDTO);
        quote = quoteRepository.save(quote);
        return quoteConverter.toQuoteDTO(quote);
    }
}






