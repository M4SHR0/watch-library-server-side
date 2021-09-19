package com.m4shr0.library.watch.controller

import com.m4shr0.library.watch.model.BookDisplayInfo
import com.m4shr0.library.watch.model.GetBookListResponse
import com.m4shr0.library.watch.service.BookService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}