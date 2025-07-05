package com.library.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void testDisplay() {
        BookService bookService = new BookService();
        bookService.display();
        assertNotNull(bookService);  // Dummy check
    }
}
