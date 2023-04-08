package com.simcodic.books.service

import com.simcodic.books.data.Book
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service()
class BookService {

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

    @DeleteMapping(value = ["/{id}"])
    fun deleteBook(@PathVariable(name = "id") id: String): String {
        return id
    }
}