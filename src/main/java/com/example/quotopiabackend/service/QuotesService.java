package com.example.quotopiabackend.service;

import com.example.quotopiabackend.dto.dtoQuote.QuoteConverter;
import com.example.quotopiabackend.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.model.Genre;
import com.example.quotopiabackend.model.Quote;
import com.example.quotopiabackend.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuotesService {
    @Autowired
    private QuotesRepository quotesRepository;

    @Autowired
    private QuoteConverter quoteConverter;

    public List<QuoteDTO> getAllQuotes() {
        List<Quote> quotes = quotesRepository.findAll();
        return quotes.stream()
                .map(quoteConverter::toQuoteDTO)
                .collect(Collectors.toList());
    }

    public QuoteDTO getQuoteById(int quoteId) {
        Optional<Quote> quoteOptional = quotesRepository.findById(quoteId);
        return quoteOptional.map(quoteConverter::toQuoteDTO).orElse(null);
    }

    public QuoteDTO createQuote(QuoteDTO quoteDTO) {
        Quote quote = quoteConverter.toQuoteModel(quoteDTO);
        quote = quotesRepository.save(quote);
        return quoteConverter.toQuoteDTO(quote);
    }

    public QuoteDTO updateQuote(int quoteId, QuoteDTO quoteDTO) {
        Quote existingQuote = quotesRepository.findById(quoteId).orElse(null);
        if (existingQuote != null) {
            // Update existingQuote based on quoteDTO
            existingQuote.setQuoteText(quoteDTO.quoteText());
            // Set other fields if needed
            existingQuote = quotesRepository.save(existingQuote);
            return quoteConverter.toQuoteDTO(existingQuote);
        }
        return null; // Quote with given ID not found
    }

    public boolean deleteQuote(int quoteId) {
        if (quotesRepository.existsById(quoteId)) {
            quotesRepository.deleteById(quoteId);
            return true;
        }
        return false; // Quote with given ID not found
    }


}



