package com.moaa.domain.books;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookRepositoryIntegrationTest.BookRepositoryIntegrationTestRunner.class)
public class BookRepositoryIntegrationTest {

    @Inject
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
    public void getBooks() {
        assertThat(bookRepository.getBooks())
                .isEmpty();
    }

    @Test
    public void createBook_givenAnIsbnAndATitleAndAnAuthor_thenCreateTheBookAndReturnTheBook() {

    }

    @Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        Book expectedBook = listOfBooksInDatabase.get(0);
        String expectedDetailsOfBook = expectedBook.getIsbn() + "\n" + expectedBook.getTitle() + "\n" +
                expectedBook.getAuthor().getFirstName() + " " + expectedBook.getAuthor().getLastName();
        String actualDetailsOfBook = bookRepository.showDetailsOfBook(listOfBooksInDatabase.get(0).getId());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }

    /*@Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        Book expectedBook = listOfBooksInDatabase.get(0);
        String expectedDetailsOfBook = expectedBook.getIsbn() + "\n" + expectedBook.getTitle() + "\n" +
                expectedBook.getAuthor().getFirstName() + " " + expectedBook.getAuthor().getLastName();
        String actualDetailsOfBook = bookRepository.showDetailsOfBook(listOfBooksInDatabase.get(0).getId());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }*/

    @SpringBootApplication
    public static class BookRepositoryIntegrationTestRunner {

        public static void main(String[] args) {
            run(BookRepositoryIntegrationTestRunner.class, args);
        }
    }

}