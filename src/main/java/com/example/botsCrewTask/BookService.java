package com.example.botsCrewTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks (){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book getBook (String name){
        return bookRepository.findOne(name);
    }

    public void addBook (Book book){
        bookRepository.save(book);
    }

    public void updateBook (Book book){
        bookRepository.save(book);
    }

    public void deleteBook(String name){
        bookRepository.delete(name);
    }
}
