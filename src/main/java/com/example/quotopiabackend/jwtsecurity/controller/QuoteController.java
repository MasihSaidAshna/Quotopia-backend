package com.example.quotopiabackend.jwtsecurity.controller;

import com.example.quotopiabackend.jwtsecurity.dto.dtoQuote.QuoteDTO;
import com.example.quotopiabackend.jwtsecurity.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/top4new")
    public ResponseEntity<List<QuoteDTO>> getTop4NewQuotes() {
        List<QuoteDTO> top4Quotes = quoteService.getTop4NewQuotes();
        return ResponseEntity.ok(top4Quotes);
    }
    @GetMapping()
    public ResponseEntity<List<QuoteDTO>> getAllQuotes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "quoteText") String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        List<QuoteDTO> quotes = quoteService.getAllQuotes(pageable).getContent();
        return ResponseEntity.ok(quotes);
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

    @GetMapping("/byGenre")
    public ResponseEntity<List<QuoteDTO>> getQuotesByGenre(@RequestParam int genreID) {
        List<QuoteDTO> quotesByGenre = quoteService.getQuotesByGenre(genreID);
        return ResponseEntity.ok(quotesByGenre);
    }



}


