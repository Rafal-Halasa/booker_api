package com.simcodic.books.presentation.book.controller

import com.simcodic.books.domain.base.data.FailOutput
import com.simcodic.books.domain.base.data.SuccessOutput
import com.simcodic.books.domain.book.data.Book
import com.simcodic.books.domain.book.service.BookService
import com.simcodic.books.presentation.base.data.ErrorResponse
import com.simcodic.books.presentation.base.data.FailResponse
import com.simcodic.books.presentation.base.data.SuccessResponse
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
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
        controller.getBooks()

        verify(bookService).getBooks()
    }

    @Test
    fun getBooks_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(bookService.getBooks()) doAnswer { SuccessOutput(listOf(book)) }

        controller.getBooks() shouldBe SuccessResponse(listOf(book))
    }

    @Test
    fun getBooks_thenGetFailResponse_whenFailOutput() {
        whenever(bookService.getBooks()) doAnswer { FailOutput(listOf(book)) }

        controller.getBooks() shouldBe FailResponse(listOf(book))
    }

    @Test
    fun getBooks_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(bookService.getBooks()) doAnswer { throw Exception() }

        controller.getBooks() shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun getBooks_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(bookService.getBooks()) doAnswer { throw Exception("BedNumber") }

        controller.getBooks() shouldBe ErrorResponse("BedNumber")
    }

    @Test
    fun putBook_thenGetCorrectValue() {
        controller.putBook(book = book)

        verify(bookService).putBook(book)
    }

    @Test
    fun putBook_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(bookService.putBook(book)) doAnswer { SuccessOutput(book) }

        controller.putBook(book) shouldBe SuccessResponse(book)
    }

    @Test
    fun putBook_thenGetFailResponse_whenFailOutput() {
        whenever(bookService.putBook(book)) doAnswer { FailOutput(book) }

        controller.putBook(book) shouldBe FailResponse(book)
    }

    @Test
    fun putBook_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(bookService.putBook(book)) doAnswer { throw Exception() }

        controller.putBook(book) shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun putBook_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(bookService.putBook(book)) doAnswer { throw Exception("BedNumber") }

        controller.putBook(book) shouldBe ErrorResponse("BedNumber")
    }

    @Test
    fun postBook_thenGetCorrectValue() {
        controller.postBook(book = book)

        verify(bookService).postBook(book)
    }

    @Test
    fun postBook_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(bookService.postBook(book)) doAnswer { SuccessOutput(book) }

        controller.postBook(book) shouldBe SuccessResponse(book)
    }

    @Test
    fun postBook_thenGetFailResponse_whenFailOutput() {
        whenever(bookService.postBook(book)) doAnswer { FailOutput(book) }

        controller.postBook(book) shouldBe FailResponse(book)
    }

    @Test
    fun postBook_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(bookService.postBook(book)) doAnswer { throw Exception() }

        controller.postBook(book) shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun postBook_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(bookService.postBook(book)) doAnswer { throw Exception("BedNumber") }

        controller.postBook(book) shouldBe ErrorResponse("BedNumber")
    }

    @Test
    fun deleteBook_thenGetCorrectValue() {
        controller.deleteBook(id)

        verify(bookService).deleteBook(id)
    }

    @Test
    fun deleteBook_thenGetSuccessResponse_whenSuccessOutput() {
        whenever(bookService.deleteBook(id)) doAnswer { SuccessOutput(id) }

        controller.deleteBook(id) shouldBe SuccessResponse(id)
    }

    @Test
    fun deleteBook_thenGetFailResponse_whenFailOutput() {
        whenever(bookService.deleteBook(id)) doAnswer { FailOutput(id) }

        controller.deleteBook(id) shouldBe FailResponse(id)
    }

    @Test
    fun deleteBook_thenGetErrorResponse_whenThrowUnknownException() {
        whenever(bookService.deleteBook(id)) doAnswer { throw Exception() }

        controller.deleteBook(id) shouldBe ErrorResponse("Unknown Exception")
    }

    @Test
    fun deleteBook_thenGetErrorResponse_whenThrowBedNumberException() {
        whenever(bookService.deleteBook(id)) doAnswer { throw Exception("BedNumber") }

        controller.deleteBook(id) shouldBe ErrorResponse("BedNumber")
    }
}