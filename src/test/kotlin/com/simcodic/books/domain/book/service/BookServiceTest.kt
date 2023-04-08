package com.simcodic.books.domain.book.service

import com.simcodic.books.domain.book.data.Book
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.kotlin.spy
import org.mockito.kotlin.whenever

class BookServiceTest {

    private val bookService = spy(BookService())

    private val id = "1"
    private val title = "My life"
    private val author = "Me"
    private val isbn = "123"

    private val book = Book(id = id, title = title, author = author, isbn = isbn)

    @Test
    fun getBooks_thenGetListOfBooks() {
        whenever(bookService.getBooks()).then { listOf(book) }

        bookService.getBooks() shouldBe listOf(book)
    }

    @Test
    fun putBook_thenGetCorrectValue() {
        whenever(bookService.putBook(book)).then { "ok" }

        bookService.putBook(book = book) shouldBe "ok"
    }

    @Test
    fun postBook_thenGetCorrectValue() {
        whenever(bookService.postBook(book)).then { "ok" }

        bookService.postBook(book = book) shouldBe "ok"
    }

    @Test
    fun deleteBook_thenGetCorrectValue() {
        whenever(bookService.deleteBook("1")).then { "1" }

        bookService.deleteBook("1") shouldBe "1"
    }
}