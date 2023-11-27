package com.example.quotopiabackend.controller;

import com.example.quotopiabackend.entity.Quotes;
import com.example.quotopiabackend.service.QuotesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class QuotesController
{
    private final QuotesService quotesService;

    @Autowired
    public QuotesController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("/quotes")
    public List<Quotes> getAllQuotes() {
        return quotesService.getAllQuotes();
    }
}
