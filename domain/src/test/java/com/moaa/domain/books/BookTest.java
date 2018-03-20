package com.moaa.domain.books;

import org.junit.Test;

import static com.moaa.domain.books.Author.AuthorBuilder.author;
import static com.moaa.domain.books.Book.BookBuilder.book;

public class BookTest {

    @Test
    public void toString_thenReturnTheDetailsOfTheBook() {
        Book book = book().withAuthor(author()
                        .withFirstName("Jan1")
                        .withLastName("Janssens1")
                        .build())
                .withIsbn("isbn1")
                .withTitle("title 1")
                .build();
        String expectedString = "isbn1\ntitle 1\nJan1 Janssens1";
        String actualString = book.toString();
        org.assertj.core.api.Assertions
                .assertThat(actualString).isEqualTo(expectedString);

    }

}