package com.simcodic.books.controller

import com.simcodic.books.data.Author
import com.simcodic.books.service.AuthorService
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class AuthorControllerTest {

    private val authorService: AuthorService = mock()
    private val controller = AuthorController(authorService)

    private val id = "1"
    private val name = "Jhony"
    private val surname = "week"
    private val nationality = "USA"

    private val author = Author(id = id, name = name, surname = surname, nationality = nationality)

    @Test
    fun getAuthors_thenGetListOfAuthors() {
        whenever(authorService.getAuthors()).then { listOf(author) }

        controller.getAuthors() shouldBe listOf(author)
    }

    @Test
    fun putAuthor_thenGetCorrectValue() {
        whenever(authorService.putAuthor(author)).then { "ok" }

        controller.putAuthor(author = author) shouldBe "ok"
    }

    @Test
    fun postAuthor_thenGetCorrectValue() {
        whenever(authorService.postAuthor(author)).then { "ok" }

        controller.postAuthor(author = author) shouldBe "ok"
    }

    @Test
    fun deleteAuthor_thenGetCorrectValue() {
        whenever(authorService.deleteAuthor("1")).then { "1" }

        controller.deleteAuthor("1") shouldBe "1"
    }
}