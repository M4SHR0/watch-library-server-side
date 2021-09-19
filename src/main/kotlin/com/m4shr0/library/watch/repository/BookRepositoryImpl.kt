package com.m4shr0.library.watch.repository

import com.m4shr0.library.watch.model.Book
import com.m4shr0.library.watch.model.RegisterBookRequest
import com.m4shr0.library.watch.model.UpdateBookRequest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class BookRepositoryImpl(
    private val jdbcTemplate: JdbcTemplate
    ) : BookRepository{
    override fun selectAll(): List<Book> {
        val rowMapper: RowMapper<Book> = RowMapper<Book> { resultSet: ResultSet, rowIndex: Int ->
            Book(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("author"),
                resultSet.getString("publisher"),
                resultSet.getString("isbn"),
                resultSet.getString("note")
            )
        }

        val sql = """
            SELECT
                id,
                name,
                author,
                publisher,
                ISBN,
                note
            FROM
                book
        """.trimIndent()

        return jdbcTemplate.query(sql,rowMapper)
    }

    override fun selectByPrimaryKey(id: Int): Book? {
        val sql = """
            SELECT
                id,
                name,
                author,
                publisher,
                ISBN,
                note
            FROM
                book
            WHERE
                id = ?
        """.trimIndent()

        try {
            val record: Map<String,Any> = jdbcTemplate.queryForMap(sql,id)

            return Book(
                record["id"].toString().toInt(),
                record["name"].toString(),
                record["author"].toString(),
                record["publisher"].toString(),
                record["ISBN"].toString(),
                record["note"].toString()
            )
        }catch (e : EmptyResultDataAccessException){
            return null
        }

    }

    override fun selectByISBN(isbn: String): Book? {
        val sql = """
            SELECT
                id,
                name,
                author,
                publisher,
                ISBN,
                note
            FROM
                book
            WHERE
                isbn = ?
        """.trimIndent()

        try {
            val record: Map<String,Any> = jdbcTemplate.queryForMap(sql,isbn)

            return Book(
                record["id"].toString().toInt(),
                record["name"].toString(),
                record["author"].toString(),
                record["publisher"].toString(),
                record["ISBN"].toString(),
                record["note"].toString()
            )
        }catch (e : EmptyResultDataAccessException){
            return null
        }

    }

    override fun registerOne(request: RegisterBookRequest) {
        val sql = """
            INSERT INTO book (
                name,
                author,
                publisher,
                ISBN,
                note
            ) VALUES (?,?,?,?,?)
        """.trimIndent()

        jdbcTemplate.update(sql,
            request.name,
            request.author,
            request.publisher,
            request.isbn,
            request.note
        )
    }

    override fun deleteOne(id: Int) {
        val sql = """
            DELETE 
            FROM 
                book
            WHERE
                id=?
        """.trimIndent()

        jdbcTemplate.update(sql,id)
    }

    override fun updateOne(request: UpdateBookRequest) {
        val sql = """
            UPDATE
                book
            SET
                name = ?,
                author = ?,
                publisher = ?,
                isbn = ?,
                note = ?
            WHERE
                id = ?
        """.trimIndent()

        jdbcTemplate.update(sql,
            request.name,
            request.author,
            request.publisher,
            request.isbn,
            request.note,
            request.id
        )
    }
}