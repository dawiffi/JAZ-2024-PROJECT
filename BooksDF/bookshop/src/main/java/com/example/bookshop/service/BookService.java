package com.example.bookshop.service;

import com.example.bookshop.model.Book;
import com.example.orders.model.Order;
import com.example.bookshop.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("Book not found"));
        book.setVisitCount(book.getVisitCount() + 1);
        if (book.getVisitCount() % 10 == 0){
            Order order = new Order();
            if (Objects.equals(book.getId(), order.getBookId())){
                order.setQuantityToOrder(order.getQuantityToOrder()+1);
            }
        }
        return bookRepository.save(book);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("Book not found"));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        Book existingBook = bookRepository.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("Book not found"));
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        books.forEach(book -> {
            book.setVisitCount(book.getVisitCount() + 1);
            if (book.getVisitCount() % 10 == 0){
                Order order = new Order();
                if (Objects.equals(book.getId(), order.getBookId())){
                    order.setQuantityToOrder(order.getQuantityToOrder()+1);
                }
            }
            bookRepository.saveAll(books);}
        );
        return books;
    }

    @Transactional
    public Book purchaseBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("Book not found"));
        if (book.getStock() > 0) {
            book.setStock(book.getStock() - 1);
            return bookRepository.save(book);
        } else {
            throw new OpenApiResourceNotFoundException("Book out of stock");
        }
    }


}
