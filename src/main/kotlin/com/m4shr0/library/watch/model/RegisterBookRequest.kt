package com.m4shr0.library.watch.model

data class RegisterBookRequest(
    var name: String,
    var author: String,
    var publisher: String,
    var isbn: String,
    var note: String
)
