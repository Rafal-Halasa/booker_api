package com.simcodic.books.controller

import com.simcodic.books.data.Author
import com.simcodic.books.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/author", produces = [MediaType.APPLICATION_JSON_VALUE])
@EnableAutoConfiguration
class AuthorController @Autowired constructor(val authorService: AuthorService) {

    @GetMapping()
    fun getAuthors(): List<Author> {
        return authorService.getAuthors()
    }

    @PutMapping()
    fun putAuthor(@RequestBody author: Author): String {
        return authorService.putAuthor(author)
    }

    @PostMapping()
    fun postAuthor(@RequestBody author: Author): String {
        return authorService.postAuthor(author)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteAuthor(@PathVariable(name = "id") id: String): String {
        return authorService.deleteAuthor(id)
    }
}