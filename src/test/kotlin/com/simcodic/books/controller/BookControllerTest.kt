package com.simcodic.books.controller

import com.simcodic.books.data.Book
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BookControllerTest {

    private val controller = BookController()

    private val book = Book("1", "My life", "Me", "123")

    @Test
    fun getBooks() {
        controller.getBooks() shouldBe listOf(book)
    }

    @Test
    fun putBook() {
        controller.putBook(book = book) shouldBe "ok"
    }

    @Test
    fun postBook() {
        controller.postBook(book = book) shouldBe "ok"
    }

    @Test
    fun deleteBook() {
        controller.deleteBook(book = book) shouldBe "ok"
    }
}