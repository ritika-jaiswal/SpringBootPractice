package com.api.book.botrestbook.dao;

import com.api.book.botrestbook.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
