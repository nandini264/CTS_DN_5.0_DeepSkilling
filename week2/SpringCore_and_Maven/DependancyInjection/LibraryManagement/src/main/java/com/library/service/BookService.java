package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    // Setter method
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void showService() {
        System.out.println("Book Service Working");
        repository.display();
    }
}