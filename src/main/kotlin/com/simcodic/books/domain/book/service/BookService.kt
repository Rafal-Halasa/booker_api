package com.simcodic.books.domain.book.service

import com.simcodic.books.domain.base.data.Output
import com.simcodic.books.domain.base.data.SuccessOutput
import com.simcodic.books.domain.book.data.Book
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service()
class BookService {

    @GetMapping()
    fun getBooks(): Output {
        return SuccessOutput(listOf(Book("1", "My life", "Me", "123")))
    }

    @PutMapping()
    fun putBook(@RequestBody book: Book): Output {
        return SuccessOutput("ok")
    }

    @PostMapping()
    fun postBook(@RequestBody book: Book): Output {
        return SuccessOutput("ok")
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteBook(@PathVariable(name = "id") id: String): Output {
        return SuccessOutput(id)
    }
}