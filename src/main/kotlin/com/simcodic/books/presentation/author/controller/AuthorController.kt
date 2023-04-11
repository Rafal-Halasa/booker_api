package com.simcodic.books.presentation.author.controller

import com.simcodic.books.domain.author.data.Author
import com.simcodic.books.domain.author.service.AuthorService
import com.simcodic.books.presentation.base.data.Response
import com.simcodic.books.presentation.base.data.makeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/author", produces = [MediaType.APPLICATION_JSON_VALUE])
@EnableAutoConfiguration
class AuthorController @Autowired constructor(val authorService: AuthorService) {

    @GetMapping()
    fun getAuthors() = makeResponse(authorService::getAuthors)

    @PutMapping()
    fun putAuthor(@RequestBody author: Author) = makeResponse { authorService.putAuthor(author) }

    @PostMapping()
    fun postAuthor(@RequestBody author: Author) = makeResponse { authorService.postAuthor(author) }

    @DeleteMapping(value = ["/{id}"])
    fun deleteAuthor(@PathVariable(name = "id") id: String): Response = makeResponse { authorService.deleteAuthor(id) }
}