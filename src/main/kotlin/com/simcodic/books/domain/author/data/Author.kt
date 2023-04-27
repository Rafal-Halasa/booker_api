package com.simcodic.books.domain.author.data

import com.simcodic.books.data.author.data.Author as AuthorEntity

data class Author(
    var id: String = "",
    var name: String,
    var surname: String,
    var nationality: String
)

fun Author.toEntity() = AuthorEntity(name = name, surname = surname, nationality = nationality)