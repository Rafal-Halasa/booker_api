package com.simcodic.books.presentation.book.controller

import com.simcodic.books.domain.book.data.Book
import com.simcodic.books.domain.book.service.BookService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

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
    fun putBook_thenGetCorrectValue() {
        controller.putBook(book = book)

        verify(bookService).putBook(book)
    }

    @Test
    fun postBook_thenGetCorrectValue() {
        controller.postBook(book = book)

        verify(bookService).postBook(book)
    }

    @Test
    fun deleteBook_thenGetCorrectValue() {
        controller.deleteBook(id)

        verify(bookService).deleteBook(id)
    }
}