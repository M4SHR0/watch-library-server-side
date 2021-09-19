package com.m4shr0.library.watch.repository

import com.m4shr0.library.watch.model.Book
import com.m4shr0.library.watch.model.RegisterBookRequest

interface BookRepository{
    fun selectAll(): List<Book>

    fun selectByPrimaryKey(id: Int): Book?

    fun selectByISBN(isbn: String): Book?

    fun registerOne(request: RegisterBookRequest)

    fun deleteOne(id: Int)
}