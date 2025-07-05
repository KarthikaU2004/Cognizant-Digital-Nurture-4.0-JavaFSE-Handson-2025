package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String serviceName;

    // Constructor Injection
    public BookService(String serviceName) {
        this.serviceName = serviceName;
        System.out.println("Constructor Injection: serviceName = " + serviceName);
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter Injection: bookRepository injected");
    }

    public void addBook(String bookName) {
        System.out.println("Adding book via " + serviceName);
        bookRepository.saveBook(bookName);
    }
}
