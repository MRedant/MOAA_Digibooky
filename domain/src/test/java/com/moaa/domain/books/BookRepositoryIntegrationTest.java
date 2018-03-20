package com.moaa.domain.books;

import org.junit.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRepositoryIntegrationTest {

    @Inject
    private BookRepository bookRepository;

    @Test
    public void getBooks() {
        assertThat(bookRepository.getBooks())
                .isNull();
    }

}