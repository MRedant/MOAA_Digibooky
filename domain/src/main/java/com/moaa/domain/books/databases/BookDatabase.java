package com.moaa.domain.books.databases;

import com.moaa.domain.books.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class BookDatabase {

    List<Book> books;

    public BookDatabase() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return unmodifiableList(books);
    }
}
