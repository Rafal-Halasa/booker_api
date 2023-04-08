package com.simcodic.books.controller

import com.simcodic.books.data.Book
import com.simcodic.books.service.BookService
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class BookControllerTest {

    private val bookService: BookService = mock()
    private val controller = BookController(bookService)

    private val id = "1"
    private val title = "My life"
    private val author = "Me"
    private val isbn = "123"

    private val book = Book(id = id, title = title, author = author, isbn = isbn)

    @Test
    fun getBooks_thenGetListOfBooks() {
        whenever(bookService.getBooks()).then { listOf(book) }

        controller.getBooks() shouldBe listOf(book)
    }

    @Test
    fun putBook() {
        whenever(bookService.putBook(book)).then { "ok" }

        controller.putBook(book = book) shouldBe "ok"
    }

    @Test
    fun postBook() {
        whenever(bookService.postBook(book)).then { "ok" }

        controller.postBook(book = book) shouldBe "ok"
    }

    @Test
    fun deleteBook() {
        whenever(bookService.deleteBook("1")).then { "1" }

        controller.deleteBook("1") shouldBe "1"
    }
}