package com.example.quotopiabackend.service;

import com.example.quotopiabackend.entity.Quotes;
import com.example.quotopiabackend.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotesService {


@Autowired
QuotesRepository quotesRepository;

    public List<Quotes> getAllQuotes() {
        List<Quotes> quotes = quotesRepository.findAll();
        return quotes;
    }
}

