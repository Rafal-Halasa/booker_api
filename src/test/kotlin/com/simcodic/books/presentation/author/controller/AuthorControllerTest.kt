package com.simcodic.books.presentation.author.controller

import com.simcodic.books.domain.author.data.Author
import com.simcodic.books.domain.author.service.AuthorService
import com.simcodic.books.domain.base.data.FailOutput
import com.simcodic.books.domain.base.data.SuccessOutput
import com.simcodic.books.presentation.base.data.ErrorResponse
import com.simcodic.books.presentation.base.data.FailResponse
import com.simcodic.books.presentation.base.data.SuccessResponse
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
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
    fun getAuthors_thenGetAuthorsFromService() {
        controller.getAuthors()

        verify(authorService).getAuthors()
    }

    @Test
    fun getAuthors_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(authorService.getAuthors()) doAnswer { SuccessOutput(listOf(author)) }

        controller.getAuthors() shouldBe SuccessResponse(listOf(author))
    }

    @Test
    fun getAuthors_thenGetFailResponse_whenFailOutput() {
        whenever(authorService.getAuthors()) doAnswer { FailOutput(listOf(author)) }

        controller.getAuthors() shouldBe FailResponse(listOf(author))
    }

    @Test
    fun getAuthors_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(authorService.getAuthors()) doAnswer { throw Exception() }

        controller.getAuthors() shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun getAuthors_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(authorService.getAuthors()) doAnswer { throw Exception("BedNumber") }

        controller.getAuthors() shouldBe ErrorResponse("BedNumber")
    }

    @Test
    fun putAuthor_thenPutAuthorsInToService() {
        controller.putAuthor(author = author)

        verify(authorService).putAuthor(author)
    }

    @Test
    fun putAuthor_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(authorService.putAuthor(author)) doAnswer { SuccessOutput(author) }

        controller.putAuthor(author) shouldBe SuccessResponse(author)
    }

    @Test
    fun putAuthor_thenGetFailResponse_whenFailOutput() {
        whenever(authorService.putAuthor(author)) doAnswer { FailOutput(author) }

        controller.putAuthor(author) shouldBe FailResponse(author)
    }

    @Test
    fun putAuthor_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(authorService.putAuthor(author)) doAnswer { throw Exception() }

        controller.putAuthor(author) shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun putAuthor_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(authorService.putAuthor(author)) doAnswer { throw Exception("BedNumber") }

        controller.putAuthor(author) shouldBe ErrorResponse("BedNumber")
    }

    @Test
    fun postAuthor_thenPostAuthorsInToService() {
        controller.postAuthor(author = author)

        verify(authorService).postAuthor(author)
    }

    @Test
    fun postAuthor_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(authorService.postAuthor(author)) doAnswer { SuccessOutput(author) }

        controller.postAuthor(author) shouldBe SuccessResponse(author)
    }

    @Test
    fun postAuthor_thenGetFailResponse_whenFailOutput() {
        whenever(authorService.postAuthor(author)) doAnswer { FailOutput(author) }

        controller.postAuthor(author) shouldBe FailResponse(author)
    }

    @Test
    fun postAuthor_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(authorService.postAuthor(author)) doAnswer { throw Exception() }

        controller.postAuthor(author) shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun postAuthor_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(authorService.postAuthor(author)) doAnswer { throw Exception("BedNumber") }

        controller.postAuthor(author) shouldBe ErrorResponse("BedNumber")
    }

    @Test
    fun deleteAuthor_thenDeleteAuthorsInToService() {
        controller.deleteAuthor(id)

        verify(authorService).deleteAuthor(id)
    }

    @Test
    fun deleteAuthor_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(authorService.deleteAuthor(id)) doAnswer { SuccessOutput(author) }

        controller.deleteAuthor(id) shouldBe SuccessResponse(author)
    }

    @Test
    fun deleteAuthor_thenGetFailResponse_whenFailOutput() {
        whenever(authorService.deleteAuthor(id)) doAnswer { FailOutput(author) }

        controller.deleteAuthor(id) shouldBe FailResponse(author)
    }

    @Test
    fun deleteAuthor_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(authorService.deleteAuthor(id)) doAnswer { throw Exception() }

        controller.deleteAuthor(id) shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun deleteAuthor_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(authorService.deleteAuthor(id)) doAnswer { throw Exception("BedNumber") }

        controller.deleteAuthor(id) shouldBe ErrorResponse("BedNumber")
    }
}