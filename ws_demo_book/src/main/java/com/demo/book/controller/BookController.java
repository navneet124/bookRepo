package com.demo.book.controller;

import java.util.Collection;
import java.util.List;

import com.demo.book.BookEntity;
import com.demo.book.service.BookService;
import com.demo.book.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;


import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/cont")
@AllArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAll() {

        List<BookDTO> bookDTOs = bookService.fetchBookList();
        return !CollectionUtils.isEmpty(bookDTOs) ? new ResponseEntity(bookDTOs, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<List<BookDTO>> getBookById(@PathVariable("bookId") Integer bookId){
        List<BookDTO> bookDTO=bookService.getBookById(bookId);
        return !CollectionUtils.isEmpty(bookDTO) ? new ResponseEntity<>(bookDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/books")
    public  ResponseEntity<HttpStatus> createBookDetails(@Valid @RequestBody List <BookDTO> bookDTO){
        List<BookEntity> bookEntities = bookService.createBookDetails(bookDTO);
        return !CollectionUtils.isEmpty(bookEntities) ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/books")
    public ResponseEntity<HttpStatus> updateBookDetailsbyBookId(@PathVariable(value = "bookId") Integer bookId,
                                             @Valid @RequestBody List<BookDTO> bookDTO){
        List<BookEntity> bookEntities=bookService.updateBookDetailsbyBookId(bookId, bookDTO);
        return !CollectionUtils.isEmpty(bookEntities) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("books/{bookId}")
    public ResponseEntity<HttpStatus> deleteBookbyId(@PathVariable("bookId") Integer bookId){

        Boolean b=bookService.deleteBookbyId(bookId);
        return b ? new ResponseEntity<>(HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
