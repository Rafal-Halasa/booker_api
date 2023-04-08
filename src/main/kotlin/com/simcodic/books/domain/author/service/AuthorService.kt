package com.simcodic.books.domain.author.service

import com.simcodic.books.domain.author.data.Author
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service()
class AuthorService {

    @GetMapping()
    fun getAuthors(): List<Author> {
        return listOf(Author("1", "Jhony", "week", "USA"))
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