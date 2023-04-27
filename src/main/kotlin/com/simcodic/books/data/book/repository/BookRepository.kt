package com.simcodic.books.data.book.repository

import com.simcodic.books.data.book.data.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, String>