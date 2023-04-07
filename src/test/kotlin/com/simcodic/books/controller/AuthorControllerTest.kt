package com.simcodic.books.controller

import com.simcodic.books.data.Author
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AuthorControllerTest {

    private val controller = AuthorController()

    private val author = Author("1", "Jhony", "week", "USA")

    @Test
    fun getBooks() {
        controller.getAuthors() shouldBe listOf(author)
    }

    @Test
    fun putBook() {
        controller.putAuthor(author = author) shouldBe "ok"
    }

    @Test
    fun postBook() {
        controller.postAuthor(author = author) shouldBe "ok"
    }

    @Test
    fun deleteBook() {
        controller.deleteAuthor("1") shouldBe "1"
    }
}