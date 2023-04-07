package com.simcodic.books.controller

import com.simcodic.books.data.Book
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BookControllerTest {

    private val controller = BookController()

    @Test
    fun getBooks() {
        controller.getBooks() shouldBe listOf(Book("1", "My life", "Me", "123"))
    }

    @Test
    fun postBooks() {
        controller.postBooks() shouldBe "ok"
    }
}