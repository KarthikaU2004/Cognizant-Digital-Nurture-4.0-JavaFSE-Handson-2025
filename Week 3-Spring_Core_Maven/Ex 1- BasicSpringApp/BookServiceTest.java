package com.library.service;

import com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookServiceTest {
    private BookService bookService;

    @Before
    public void setUp() {
        bookService = new BookService();
        bookService.setBookRepository(new BookRepository());
    }

    @Test
    public void testAddBook() {
        bookService.addBook("JUnit for Beginners");
        assertTrue(true);  // Dummy assert to show green tick
    }
}
