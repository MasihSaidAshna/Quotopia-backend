package com.example.quotopiabackend.controller;

import com.example.quotopiabackend.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Autowired
    private QuotesService quotesService;

    @GetMapping
    public ResponseEntity<List<QuoteDTO>> getAllQuotes() {
        return ResponseEntity.ok(quotesService.getAllQuotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteDTO> getQuoteById(@PathVariable int id) {
        QuoteDTO quoteDTO = quotesService.getQuoteById(id);
        return (quoteDTO != null) ? ResponseEntity.ok(quoteDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<QuoteDTO> createQuote(@RequestBody QuoteDTO quoteDTO) {
        QuoteDTO createdQuote = quotesService.createQuote(quoteDTO);
        return ResponseEntity.ok(createdQuote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuoteDTO> updateQuote(@PathVariable int id, @RequestBody QuoteDTO quoteDTO) {
        QuoteDTO updatedQuote = quotesService.updateQuote(id, quoteDTO);
        return (updatedQuote != null) ? ResponseEntity.ok(updatedQuote) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable int id) {
        boolean deleted = quotesService.deleteQuote(id);
        return (deleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }




}
