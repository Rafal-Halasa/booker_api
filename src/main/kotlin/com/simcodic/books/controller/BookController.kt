package com.simcodic.books.controller

import com.simcodic.books.data.Book
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
@EnableAutoConfiguration
class BookController {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBooks(): List<Book> {
        return listOf(Book("1", "My life", "Me", "123"))
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putBook(@RequestBody book: Book): String {
        return "ok"
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postBook(@RequestBody book: Book): String {
        return "ok"
    }
}