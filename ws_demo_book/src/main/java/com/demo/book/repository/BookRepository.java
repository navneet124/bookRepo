package com.demo.book.repository;

import com.demo.book.BookDTO;
import com.demo.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    //public List<BookEntity> findById(int book_id);

}
