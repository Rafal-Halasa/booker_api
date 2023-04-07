package com.simcodic.books.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
@EnableAutoConfiguration
class BookController {
    @GetMapping(value = ["/obtain"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBooks():String{
        return "done"
    }
}