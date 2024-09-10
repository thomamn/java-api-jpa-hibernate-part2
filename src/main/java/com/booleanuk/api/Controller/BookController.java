package com.booleanuk.api.Controller;

import com.booleanuk.api.Model.Author;
import com.booleanuk.api.Model.Book;
import com.booleanuk.api.Repository.AuthorRepository;
import com.booleanuk.api.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("books")
class BookController {

    @Autowired
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<Book>(this.repository.save(book),
                HttpStatus.CREATED);


    }

    @GetMapping
    public List<Book> getAll() {
        return this.repository.findAll();
    }



    @GetMapping("{id}")
    public Book getById(@PathVariable("id") Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,
                                               @RequestBody Book book){
        Book bookToUpdate=this.repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No book with that ID found")
        );
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setGenre(book.getGenre());
        return new ResponseEntity<Book>(this.repository.save(bookToUpdate
        ), HttpStatus.CREATED);



    }

    @DeleteMapping("{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id){
        Book bookToDelete=this.repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No book with that ID found")
        );

        this.repository.delete(bookToDelete);
        return ResponseEntity.ok(bookToDelete);
    }
}
