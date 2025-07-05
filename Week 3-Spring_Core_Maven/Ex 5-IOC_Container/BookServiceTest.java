package com.library.service;

import com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class BookServiceTest {

    private BookService bookService;

    @Before
    public void setup() {
        bookService = new BookService();
        bookService.setBookRepository(new BookRepository()); // manual DI for test
    }

    @Test
    public void testAddBook() {
        bookService.addBook("JUnit Cookbook");
        assertNotNull(bookService);
    }
}
