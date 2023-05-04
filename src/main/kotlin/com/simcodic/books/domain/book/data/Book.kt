package com.simcodic.books.domain.book.data

import com.simcodic.books.data.book.data.Book as BookEntity

data class Book(
    var id: String?,
    var title: String,
    var author: String,
    var isbn: String
)

fun Book.toEntity() = BookEntity(title = title, author = author, isbn = isbn)