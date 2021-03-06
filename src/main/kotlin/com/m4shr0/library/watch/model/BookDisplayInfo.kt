package com.m4shr0.library.watch.model

data class BookDisplayInfo(
    var id: Int,
    var name: String,
    var author: String,
    var publisher: String,
    var note: String
) {
    constructor(model: Book) : this(model.id,model.name,model.author,model.publisher,model.note)
}
