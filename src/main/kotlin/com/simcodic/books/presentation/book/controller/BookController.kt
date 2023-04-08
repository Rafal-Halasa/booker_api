package com.simcodic.books.presentation.book.controller

import com.simcodic.books.domain.book.data.Book
import com.simcodic.books.domain.book.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books", produces = [MediaType.APPLICATION_JSON_VALUE])
@EnableAutoConfiguration
class BookController @Autowired constructor(val bookService: BookService) {

    @GetMapping()
    fun getBooks(): List<Book> {
        return bookService.getBooks()
    }

    @PutMapping()
    fun putBook(@RequestBody book: Book): String {
        return bookService.putBook(book = book)
    }

    @PostMapping()
    fun postBook(@RequestBody book: Book): String {
        return bookService.postBook(book = book)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteBook(@PathVariable(name = "id") id: String): String {
        return bookService.deleteBook(id = id)
    }
}