package com.simcodic.books.domain.author.service

import com.simcodic.books.data.author.repository.AuthorRepository
import com.simcodic.books.domain.author.data.Author
import com.simcodic.books.domain.base.data.SuccessOutput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.spy
import org.mockito.kotlin.whenever
import java.util.*

class AuthorServiceTest {

    private val authorRepository: AuthorRepository = mock()
    private val authorService = spy(AuthorService(authorRepository))

    private val id = "1"
    private val name = "Jhony"
    private val surname = "week"
    private val nationality = "USA"

    private val author = Author(id = id, name = name, surname = surname, nationality = nationality)

    @Test
    fun getAuthors_thenGetListOfAuthors() {
        whenever(authorService.getAuthors()).then { SuccessOutput(listOf(author)) }

        authorService.getAuthors().value shouldBe listOf(author)
    }

    @Test
    fun putAuthor_thenGetCorrectValue() {
        whenever(authorService.putAuthor(author)).then { SuccessOutput("ok") }

        authorService.putAuthor(author = author).value shouldBe "ok"
    }

    @Test
    fun postAuthor_thenGetCorrectValue() {
        whenever(authorRepository.findById(id)).then {
            Optional.of(
                com.simcodic.books.data.author.data.Author(
                    id,
                    name,
                    surname,
                    nationality
                )
            )
        }

        whenever(authorService.postAuthor(author)).then { SuccessOutput("ok") }

        authorService.postAuthor(author = author).value shouldBe "ok"
    }

    @Test
    fun deleteAuthor_thenGetCorrectValue() {
        whenever(authorService.deleteAuthor("1")).then { SuccessOutput("1") }

        authorService.deleteAuthor("1").value shouldBe "1"
    }
}