package com.moaa.service.books;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

// adapted code from funiversity
public class BookService {

    private final BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public String showDetailsOfBook(UUID bookId){
        return bookRepository.showDetailsOfBook(bookId);
    }
}
