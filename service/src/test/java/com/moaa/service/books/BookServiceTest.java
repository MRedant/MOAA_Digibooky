package com.moaa.service.books;

import com.moaa.domain.books.Author;
import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
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
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    public List<Book> populateBookDatabase() {
        Book book1 = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn("isbn1")
                .withTitle("title 1")
                .build();
        Book book2 = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan2")
                .withLastName("Janssens2")
                .build())
                .withIsbn("isbn2")
                .withTitle("title 2")
                .build();
        Book book3 = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan3")
                .withLastName("Janssens3")
                .build())
                .withIsbn("isbn3")
                .withTitle("title 3")
                .build();
        return new ArrayList<>(Arrays.asList(book1, book2, book3));
    }

    @Test
    public void getBooks_happyPath(){
        List<Book> expectedBooks = populateBookDatabase();
        Mockito.when(bookRepository.getBooks())
                .thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.getBooks();

        assertThat(actualBooks)
                .containsExactly(expectedBooks.toArray(new Book[0]));
    }

    @Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        Mockito.when(bookRepository.showDetailsOfBook(listOfBooksInDatabase.get(0).getId()))
                .thenReturn("isbn1\ntitle 1\nJan1 Janssens1");
        Book expectedBook = listOfBooksInDatabase.get(0);
        String expectedDetailsOfBook = expectedBook.getIsbn() + "\n" + expectedBook.getTitle() + "\n" +
                expectedBook.getAuthor().getFirstName() + " " + expectedBook.getAuthor().getLastName();
        String actualDetailsOfBook = bookService.showDetailsOfBook(listOfBooksInDatabase.get(0).getId());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }

}
