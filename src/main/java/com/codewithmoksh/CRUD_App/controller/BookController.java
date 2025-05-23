package com.codewithmoksh.CRUD_App.controller;

import com.codewithmoksh.CRUD_App.model.Book;
import com.codewithmoksh.CRUD_App.repository.BookRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        try{
            List<Book> bookList = new ArrayList<>(bookRepository.findAll());

            if(bookList.isEmpty()){
                return new ResponseEntity<>(bookList, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){

        Optional<Book> bookData = bookRepository.findById(id);

        return bookData.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book bookObj = bookRepository.save(book);

        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    }

    @PutMapping("updateBookById/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBookData){
         Optional<Book> oldBookData = bookRepository.findById(id);
         if(oldBookData.isPresent()){
              Book updatedBookData = oldBookData.get();
              updatedBookData.setTitle(newBookData.getTitle());
              updatedBookData.setAuthor(newBookData.getAuthor());

              Book bookObj = bookRepository.save(updatedBookData);

              return new ResponseEntity<>(bookObj, HttpStatus.OK);
         }

         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id){
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
