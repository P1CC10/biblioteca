package com.develhope.biblioteca.controllers;

import com.develhope.biblioteca.entitis.Book;
import com.develhope.biblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    public BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Book>> findAllBook() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findBookById(id);
        if (bookOptional.isPresent()) {
            return ResponseEntity.ok(bookOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookOptional = bookService.updateBook(book, id);
        if (bookOptional.isPresent()) {
            return ResponseEntity.ok(bookOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.deleteBook(id);
        if (bookOptional.isPresent()) {
            return ResponseEntity.ok(bookOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/lend/{id}")
    public ResponseEntity<?> lendBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.lendBook(id);
        if (optionalBook.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.returnBook(id);
        if (optionalBook.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
