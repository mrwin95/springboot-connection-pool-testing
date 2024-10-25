package com.example.connection_pool_testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.connection_pool_testing.repo.AuthorRepository;

@RequestMapping("/api")
@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/author")
    public void fetchAuthor() {
        authorRepository.fetchUsers();
    }
}
