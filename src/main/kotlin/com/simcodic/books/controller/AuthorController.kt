package com.simcodic.books.controller

import com.simcodic.books.data.Author
import com.simcodic.books.data.Book
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/author", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
@EnableAutoConfiguration
class AuthorController {

    @GetMapping()
    fun getAuthors(): List<Author> {
        return listOf(Author("1","Jhony","week", "USA"))
    }

    @PutMapping()
    fun putAuthor(@RequestBody author: Author): String {
        return "ok"
    }

    @PostMapping()
    fun postAuthor(@RequestBody author: Author): String {
        return "ok"
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteAuthor(@PathVariable(name = "id") id: String): String {
        return id
    }
}