package com.moaa.domain.books;

import com.moaa.domain.books.databases.BookDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest {

    @Mock
    private BookDatabase bookDatabase;

    @InjectMocks
    private BookRepository bookRepository;

    @Test
    public void getBooks_happyPath() {
        List<Book> expectedBooks = new ArrayList<>(Arrays.asList(
                book().withAuthor(Author.AuthorBuilder.author()
                            .withFirstName("Jan1")
                            .withLastName("Janssens1")
                            .build())
                .withIsbn("isbn1")
                .withTitle("title 1")
                .build(),
                book().withAuthor(Author.AuthorBuilder.author()
                        .withFirstName("Jan2")
                        .withLastName("Janssens2")
                        .build())
                        .withIsbn("isbn2")
                        .withTitle("title 2")
                        .build(),
                book().withAuthor(Author.AuthorBuilder.author()
                        .withFirstName("Jan3")
                        .withLastName("Janssens3")
                        .build())
                        .withIsbn("isbn3")
                        .withTitle("title 3")
                        .build()
        ));
        Mockito.when(bookRepository.getBooks())
                .thenReturn(expectedBooks);

        List<Book> actualBooks = bookRepository.getBooks();

        assertThat(actualBooks)
                .containsExactly(expectedBooks.toArray(new Book[0]));
    }

}