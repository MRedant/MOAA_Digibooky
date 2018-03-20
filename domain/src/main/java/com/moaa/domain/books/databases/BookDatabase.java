package com.moaa.domain.books.databases;

import com.moaa.domain.books.Author;
import com.moaa.domain.books.Book;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static java.util.Collections.unmodifiableList;

@Named
public class BookDatabase {

    private List<Book> books;

    public BookDatabase() {
        this.books = new ArrayList<>();
        books.add(book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn("isbn1")
                .withTitle("title 1")
                .build());
    }

    public List<Book> getBooks() {
        return unmodifiableList(books);
    }
}
