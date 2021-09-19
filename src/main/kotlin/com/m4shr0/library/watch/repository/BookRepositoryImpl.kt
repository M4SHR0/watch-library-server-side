package com.m4shr0.library.watch.repository

import com.m4shr0.library.watch.model.Book
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
                resultSet.getString("note"))
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
}