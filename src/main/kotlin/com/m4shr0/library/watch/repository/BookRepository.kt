package com.m4shr0.library.watch.repository

import com.m4shr0.library.watch.model.Book

interface BookRepository{
    fun selectAll(): List<Book>
}