package com.moaa.domain.books;

import com.moaa.domain.books.databases.BookDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.unmodifiableList;

@Named
public class BookRepository {

    @Inject
    private BookDatabase bookDatabase;

    public List<Book> getBooks() {
        return unmodifiableList(bookDatabase.getBooks());
    }

    public String showDetailsOfBook(UUID bookId) {
        return bookDatabase.getBooks().stream()
                .filter(b->b.getId().equals(bookId))
                .findFirst()
                .get()
                .toString();
    }
}
