package com.booleanuk.api.Controller;

import com.booleanuk.api.Model.Author;
import com.booleanuk.api.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private final AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return new ResponseEntity<Author>(this.repository.save(author),
                HttpStatus.CREATED);


    }

    @GetMapping
    public List<Author> getAll() {
        return this.repository.findAll();
    }



    @GetMapping("{id}")
    public Author getById(@PathVariable("id") Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    @PutMapping("{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable int id,
                                           @RequestBody Author author){
        Author authorToUpdate=this.repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No author with that ID found")
        );
        authorToUpdate.setFirst_name(author.getFirst_name());
        authorToUpdate.setLast_name(author.getLast_name());
        authorToUpdate.setEmail(author.getEmail());
        authorToUpdate.setAlive(author.isAlive());
        return new ResponseEntity<Author>(this.repository.save(authorToUpdate
        ), HttpStatus.CREATED);



    }

    @DeleteMapping("{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable int id){
        Author authorToDelete=this.repository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No author with that ID found")
        );

        this.repository.delete(authorToDelete);
        return ResponseEntity.ok(authorToDelete);
    }
}
