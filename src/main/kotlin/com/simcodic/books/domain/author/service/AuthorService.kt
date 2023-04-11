package com.simcodic.books.domain.author.service

import com.simcodic.books.domain.author.data.Author
import com.simcodic.books.domain.base.data.Output
import com.simcodic.books.domain.base.data.SuccessOutput
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service()
class AuthorService {

    @GetMapping()
    fun getAuthors(): Output {
        return SuccessOutput(listOf(Author("1", "Jhony", "week", "USA")))
    }

    @PutMapping()
    fun putAuthor(@RequestBody author: Author): Output {
        return SuccessOutput("ok")
    }

    @PostMapping()
    fun postAuthor(@RequestBody author: Author): Output {
        return SuccessOutput("ok")
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteAuthor(@PathVariable(name = "id") id: String): Output {
        return SuccessOutput(id)
    }
}