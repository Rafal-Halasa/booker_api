package com.simcodic.books

import com.simcodic.books.controller.BookController
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BooksApplicationTests {

	val controller = BookController()

	@Test
	fun contextLoads() {
		controller.getBooks() shouldBe "done"
	}

}
