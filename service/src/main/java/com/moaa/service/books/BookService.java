package com.moaa.service.books;

import com.moaa.domain.books.BookRepository;

import javax.inject.Inject;

public class BookService {
    
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
