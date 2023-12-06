package com.example.quotopiabackend.jwtsecurity.controller;

import com.example.quotopiabackend.jwtsecurity.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.jwtsecurity.model.Quote;
import com.example.quotopiabackend.jwtsecurity.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/quote")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

/*    @GetMapping()
    public ResponseEntity<List<QuoteDTO>> getAllQuotes() {
            return ResponseEntity.ok(quoteService.getAllQuotes());
        }*/

    @GetMapping
    public Page<QuoteDTO> getAllQuotes(Pageable pageable) {
        return quoteService.getAllQuotes(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteDTO> getQuoteById(@PathVariable int id) {
        QuoteDTO quoteDTO = quoteService.getQuoteById(id);
        return (quoteDTO != null) ? ResponseEntity.ok(quoteDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<QuoteDTO> createQuote(@RequestBody QuoteDTO quoteDTO) {
        QuoteDTO createdQuote = quoteService.createQuote(quoteDTO);
        return ResponseEntity.ok(createdQuote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuoteDTO> updateQuote(@PathVariable int id, @RequestBody QuoteDTO quoteDTO) {
        QuoteDTO updatedQuote = quoteService.updateQuote(id, quoteDTO);
        return (updatedQuote != null) ? ResponseEntity.ok(updatedQuote) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable int id) {
        boolean deleted = quoteService.deleteQuote(id);
        return (deleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


}


