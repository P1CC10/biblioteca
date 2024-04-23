package com.develhope.biblioteca.services;

import com.develhope.biblioteca.entitis.Book;
import com.develhope.biblioteca.repositorys.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    public Optional<Book> updateBook(Book book, Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookOptional.get().setTitle(book.getTitle());
            bookOptional.get().setAuthor(book.getAuthor());
            bookOptional.get().setYearPublication(book.getYearPublication());
            bookOptional.get().setAvailable(book.getAvailable());
            bookRepository.save(bookOptional.get());
        }
        return bookOptional;
    }

    public Optional<Book> deleteBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
        }
        return bookOptional;
    }

    public Optional<Book> lendBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.setAvailable(book.getAvailable())) {
                book.setAvailable(false);
                bookRepository.save(book);
            }
        }
        return optionalBook;
    }

    public Optional<Book> returnBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (!book.setAvailable(book.getAvailable())) {
                book.setAvailable(true);
                bookRepository.save(book);
            }
        }
        return optionalBook;
    }
}
