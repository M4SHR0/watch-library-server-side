DROP DATABASE IF EXISTS book_db;

CREATE DATABASE library_db;

USE library_db;

DROP TABLE IF EXISTS book;

CREATE TABLE book(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    author VARCHAR(32) NOT NULL,
    publisher VARCHAR(32) NOT NULL,
    ISBN VARCHAR(32) NOT NULL,
    note VARCHAR(64) NOT NULL
);

INSERT INTO book (name,author,publisher,ISBN,note)
    VALUES
    ("リーダブルコード",
    "Dustin Boswell",
    "オライリー",
    "978-4-87311-565-8",
    "https://www.oreilly.co.jp/books/9784873115658/"),
    ("テスト駆動開発",
    "Kent Beck",
    "オーム",
    "978-4-274-21788-3",
    "大学図書館"),
    ("マスタリングTCP/IP入門編",
    "井上 直也",
    "オーム",
    "978-4-274-22447-8",
    "所有");
