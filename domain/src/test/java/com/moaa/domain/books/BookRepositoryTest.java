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
import java.util.NoSuchElementException;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest {

    @Mock
    private BookDatabase bookDatabase;

    @InjectMocks
    private BookRepository bookRepository;

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
        List<Book> listOfBooks = new ArrayList<>(Arrays.asList(book1, book2, book3));
        return listOfBooks;
    }

    @Test
    public void getBooks_happyPath() {
        List<Book> expectedBooks = populateBookDatabase();
        when(bookDatabase.getBooks())
                .thenReturn(expectedBooks);

        List<Book> actualBooks = bookRepository.getBooks();

        assertThat(actualBooks)
                .containsExactly(expectedBooks.toArray(new Book[0]));
    }

    @Test
    public void createBook_thenCallCreateBookInDatabaseAndReturnCreatedBook() {
        Book book = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan10")
                .withLastName("Janssens10")
                .build())
                .withIsbn("isbn10")
                .withTitle("title 10")
                .build();
        when(bookDatabase.createBook(book.getIsbn(), book.getTitle(), book.getAuthor()))
                .thenReturn(book);

        assertThat(bookRepository.createBook(book.getIsbn(), book.getTitle(), book.getAuthor()))
            .isEqualTo(book);
    }

    @Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        when(bookDatabase.getBooks()).thenReturn(listOfBooksInDatabase);
        Book expectedBook = listOfBooksInDatabase.get(0);
        String expectedDetailsOfBook = expectedBook.getIsbn() + "\n" + expectedBook.getTitle() + "\n" +
                                        expectedBook.getAuthor().getFirstName() + " " + expectedBook.getAuthor().getLastName();
        String actualDetailsOfBook = bookRepository.showDetailsOfBook(listOfBooksInDatabase.get(0).getId());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }

    @Test
    public void showDetailsOfBook_givenANonPresentBookId_thenThrowException() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        when(bookDatabase.getBooks()).thenReturn(listOfBooksInDatabase);
        Book expectedBook = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan5")
                .withLastName("Janssens5")
                .build())
                .withIsbn("isbn5")
                .withTitle("title 5")
                .build();
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(()->bookRepository.showDetailsOfBook(expectedBook.getId()))
                .withMessage("No value present");
    }

}