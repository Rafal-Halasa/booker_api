package com.simcodic.books.controller

import com.simcodic.books.data.Book
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
@EnableAutoConfiguration
class BookController {

    @GetMapping()
    fun getBooks(): List<Book> {
        return listOf(Book("1", "My life", "Me", "123"))
    }

    @PutMapping()
    fun putBook(@RequestBody book: Book): String {
        return "ok"
    }

    @PostMapping()
    fun postBook(@RequestBody book: Book): String {
        return "ok"
    }

    @DeleteMapping()
    fun deleteBook(@RequestBody book: Book): String {
        return "ok"
    }
}