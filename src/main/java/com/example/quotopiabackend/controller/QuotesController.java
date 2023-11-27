package com.example.quotopiabackend.controller;

import com.example.quotopiabackend.entity.Quotes;
import com.example.quotopiabackend.service.QuotesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class QuotesController
{
    private final QuotesService quotesService;

    public QuotesController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("/quotes")
    public List<Quotes> getAllQuotes() {
        return quotesService.getAllQuotes();
    }
}
