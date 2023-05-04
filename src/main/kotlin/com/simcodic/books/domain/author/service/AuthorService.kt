package com.simcodic.books.domain.author.service

import com.simcodic.books.data.author.repository.AuthorRepository
import com.simcodic.books.domain.author.data.Author
import com.simcodic.books.domain.author.data.toEntity
import com.simcodic.books.domain.base.data.FailOutput
import com.simcodic.books.domain.base.data.Output
import com.simcodic.books.domain.base.data.SuccessOutput
import com.simcodic.books.domain.exceptions.FieldNotFound
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service()
class AuthorService @Autowired constructor(val authorRepository: AuthorRepository) {

    @GetMapping()
    fun getAuthors(): Output = authorRepository.findAll().run { SuccessOutput(this) }

    @PutMapping()
    fun putAuthor(@RequestBody author: Author): Output =
        authorRepository.save(author.toEntity()).run { SuccessOutput("") }

    @PostMapping()
    fun postAuthor(@RequestBody author: Author): Output = with(authorRepository) {
        author.id?.let {
            val authorCopy = findById(it).get().copy(
                name = author.name,
                surname = author.surname,
                nationality = author.nationality
            )
            save(authorCopy)
            SuccessOutput("")
        } ?: FailOutput(FieldNotFound())
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteAuthor(@PathVariable(name = "id") id: String): Output =
        authorRepository.deleteById(id).run { SuccessOutput("") }
}