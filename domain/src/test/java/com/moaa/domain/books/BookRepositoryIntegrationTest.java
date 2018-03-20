package com.moaa.domain.books;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRepositoryIntegrationTest {

    @Inject
    private BookRepository bookRepository;

    @Test
    public void getBooks() {
        assertThat(bookRepository.getBooks())
                .isEmpty();
    }

}