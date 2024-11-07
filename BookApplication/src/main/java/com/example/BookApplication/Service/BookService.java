package com.example.BookApplication.Service;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book insertBook(Book book)
    {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
    public Book getBookByName(String author)
    {
        Book fetchedBook = bookRepository.findBookByAuthor(author);
        return fetchedBook;

    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
         bookRepository.deleteById(id);
    }
}
