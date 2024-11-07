package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/addBook")
    public ResponseEntity<Book> insertBook(@RequestBody Book book)
    {
        Book savedBook = bookService.insertBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("getBookByAuthor/{author}")
    public ResponseEntity<Book> getBook(@PathVariable String author)
    {
        Book fetchedBook = bookService.getBookByName(author);
        return ResponseEntity.ok(fetchedBook);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book)
    {
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }



}
