package com.m4shr0.library.watch.controller

import com.m4shr0.library.watch.model.*
import com.m4shr0.library.watch.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
@CrossOrigin
class BookController(
    private val bookService: BookService
) {
    @GetMapping("/list")
    fun getList(): GetBookListResponse{
        val bookList = bookService.getList().map{
            BookDisplayInfo(it)
        }
        return GetBookListResponse(bookList)
    }

    @GetMapping("/detail/{id}")
    fun getDetail(@PathVariable("id") id: Int): GetBookDetailResponse {
        return GetBookDetailResponse(bookService.getDetail(id))
    }

    @PostMapping("/register")
    fun registerBook(@RequestBody request: RegisterBookRequest){
        bookService.registerBook(
            RegisterBookRequest(
                request.name,
                request.author,
                request.publisher,
                request.isbn,
                request.note
            )
        )
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBook(@PathVariable("id") id: Int){
        bookService.deleteBook(id)
    }
}