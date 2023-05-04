package com.simcodic.books.domain.book.service

import com.simcodic.books.data.book.repository.BookRepository
import com.simcodic.books.domain.base.data.FailOutput
import com.simcodic.books.domain.base.data.Output
import com.simcodic.books.domain.base.data.SuccessOutput
import com.simcodic.books.domain.book.data.Book
import com.simcodic.books.domain.book.data.toEntity
import com.simcodic.books.domain.exceptions.FieldNotFound
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service()
class BookService @Autowired constructor(val bookRepository: BookRepository) {

    @GetMapping()
    fun getBooks(): Output = bookRepository.findAll().run { SuccessOutput(this) }

    @PutMapping()
    fun putBook(@RequestBody book: Book): Output = bookRepository.save(book.toEntity()).run { SuccessOutput("") }


    @PostMapping()
    fun postBook(@RequestBody book: Book): Output = with(bookRepository) {
        book.id?.let {
            val bookCopy = findById(it).get().copy(
                title = book.title,
                author = book.author,
                isbn = book.isbn
            )
            save(bookCopy)
            SuccessOutput("")
        } ?: FailOutput(FieldNotFound())
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteBook(@PathVariable(name = "id") id: String): Output =
        bookRepository.deleteById(id).run { SuccessOutput("") }
}