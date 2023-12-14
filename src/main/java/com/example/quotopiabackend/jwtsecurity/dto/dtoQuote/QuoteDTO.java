package com.example.quotopiabackend.jwtsecurity.dto.dtoQuote;

public record QuoteDTO(int quoteID, String quoteText, AuthorDTO author, GenreDTO genre) {
    public record AuthorDTO(int authorID, String authorName) {}
    public record GenreDTO(int genreID, String genreName) {}
}

