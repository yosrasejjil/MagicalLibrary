package com.example.MagicalLibraryy.services;


import com.example.MagicalLibraryy.Repositories.BookRepository;
import com.example.MagicalLibraryy.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
        @Autowired
        BookRepository bookRepository;

        public List<Book> getAllBooks(){ return bookRepository.findAll(); }
        public void addBook(Book book){
            bookRepository.save(book);
        }
        public void removeBookById(long id){
           bookRepository.deleteById(id);}
            public Optional<Book> getBookById(long id){
                return bookRepository.findById(id);
            }


}
