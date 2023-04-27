package com.simcodic.books.data.author.repository

import com.simcodic.books.data.author.data.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, String>