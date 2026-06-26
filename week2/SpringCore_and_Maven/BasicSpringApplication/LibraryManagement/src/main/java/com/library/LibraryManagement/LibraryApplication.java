package com.library.LibraryManagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;
import com.library.service.BookService;

public class LibraryApplication {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service=context.getBean("bookService", BookService.class);
        service.showService();
        
        BookRepository repo=context.getBean("bookRepository", BookRepository.class);
        repo.display();
    }
}