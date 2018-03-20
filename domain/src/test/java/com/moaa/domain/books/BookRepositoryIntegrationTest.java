package com.moaa.domain.books;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.moaa.domain.books.Author.AuthorBuilder.author;
import static com.moaa.domain.books.Book.BookBuilder.book;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookRepositoryIntegrationTest.BookRepositoryIntegrationTestRunner.class)
public class BookRepositoryIntegrationTest {

    @Inject
    private BookRepository bookRepository;

    @Test
    public void getBooks() {
        assertThat(bookRepository.getBooks())
                .isEmpty();
    }

    @SpringBootApplication
    public static class BookRepositoryIntegrationTestRunner {

        public static void main(String[] args) {
            run(BookRepositoryIntegrationTestRunner.class, args);
        }
    }

}