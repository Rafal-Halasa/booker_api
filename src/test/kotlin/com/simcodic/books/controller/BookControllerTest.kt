package com.simcodic.books.controller

import com.simcodic.books.domain.book.data.Book
import com.simcodic.books.presentation.book.controller.BookController
import com.simcodic.books.domain.book.service.BookService
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
    fun putBook_thenGetCorrectValue() {
        whenever(bookService.putBook(book)).then { "ok" }

        controller.putBook(book = book) shouldBe "ok"
    }

    @Test
    fun postBook_thenGetCorrectValue() {
        whenever(bookService.postBook(book)).then { "ok" }

        controller.postBook(book = book) shouldBe "ok"
    }

    @Test
    fun deleteBook_thenGetCorrectValue() {
        whenever(bookService.deleteBook("1")).then { "1" }

        controller.deleteBook("1") shouldBe "1"
    }
}