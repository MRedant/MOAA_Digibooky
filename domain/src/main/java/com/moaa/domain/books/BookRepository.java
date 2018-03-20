package com.moaa.domain.books;

import com.moaa.domain.books.databases.BookDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Named
public class BookRepository {

    @Inject
    private BookDatabase bookDatabase;

    public List<Book> getBooks() {
        return unmodifiableList(bookDatabase.getBooks());
    }
}
