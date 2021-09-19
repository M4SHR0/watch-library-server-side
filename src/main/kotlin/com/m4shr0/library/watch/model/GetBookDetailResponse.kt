package com.m4shr0.library.watch.model

data class GetBookDetailResponse(
    var id: Int,
    var name: String,
    var author: String,
    var publisher: String,
    var isbn: String,
    var note: String
) {
    constructor(model: Book) : this(
        model.id,
        model.name,
        model.author,
        model.publisher,
        model.isbn,
        model.note)
}
