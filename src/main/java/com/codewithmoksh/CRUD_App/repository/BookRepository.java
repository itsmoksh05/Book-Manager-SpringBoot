package com.codewithmoksh.CRUD_App.repository;


import com.codewithmoksh.CRUD_App.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
