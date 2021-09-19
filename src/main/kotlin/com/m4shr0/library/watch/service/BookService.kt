package com.m4shr0.library.watch.service

import com.m4shr0.library.watch.model.Book
import com.m4shr0.library.watch.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<Book>{
        return bookRepository.selectAll()
    }
}