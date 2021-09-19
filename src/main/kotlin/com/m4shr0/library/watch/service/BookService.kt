package com.m4shr0.library.watch.service

import com.m4shr0.library.watch.model.Book
import com.m4shr0.library.watch.model.RegisterBookRequest
import com.m4shr0.library.watch.model.UpdateBookRequest
import com.m4shr0.library.watch.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<Book>{
        return bookRepository.selectAll()
    }

    fun getDetail(id: Int): Book {
        return bookRepository.selectByPrimaryKey(id) ?: throw IllegalArgumentException("id($id) is not exist")
    }

    fun getDetail(isbn: String): Book {
        return bookRepository.selectByISBN(isbn) ?: throw IllegalArgumentException("isbn($isbn) is not exist")
    }

    @Transactional
    fun registerBook(request: RegisterBookRequest){
        bookRepository.selectByISBN(request.isbn)?.let{ throw IllegalArgumentException("book(${request.isbn}) is exist")}
        bookRepository.registerOne(request)
    }

    @Transactional
    fun deleteBook(id: Int){
        bookRepository.deleteOne(id)
    }

    @Transactional
    fun updateBook(request: UpdateBookRequest){
        bookRepository.updateOne(request)
    }
}