package com.demo.book.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.demo.book.BookDTO;
import com.demo.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import com.demo.book.mapper.BookMapper;
import com.demo.book.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> fetchBookList() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream().map(book -> bookMapper.toBookDTO(book)).collect(Collectors.toList());

    }

    @Transactional
    public List<BookDTO> getBookById(int bookId){
        List<BookEntity> bookEntities = bookRepository.findAllById(Collections.singleton(bookId));
        return bookEntities.stream()
                .map(book -> bookMapper.toBookDTO(book))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<BookEntity> createBookDetails(List<BookDTO> bookDTO){

        List<BookEntity> bookEntities = bookDTO.stream()
                .map(bookDto -> bookMapper.toBook(bookDto)).collect(Collectors.toList());

        return  bookRepository.saveAll(bookEntities);
    }

    @Transactional
    public List<BookEntity> updateBookDetailsbyBookId(Integer bookId, List<BookDTO> bookDTO) {

        List<BookDTO> bookDTOS1 = getBookById(bookId);
        if (CollectionUtils.isEmpty(bookDTOS1)) {
            throw new ResourceNotFoundException("BOOK_DOESNOT_EXISTS");
        }
        List<BookEntity> bookEntities = bookDTO.stream()
                .map(bookDto -> bookMapper.toBook(bookDto)).collect(Collectors.toList());
        return  bookRepository.saveAll(bookEntities);
    }
    @Transactional
    public boolean deleteBookbyId(Integer bookId){

        List<BookDTO> bookDTO = getBookById(bookId);
        if (CollectionUtils.isEmpty(bookDTO)) {
            return false;
        }
       /* List<BookEntity> bookEntities = bookDTO.stream()
                .map(bookDto -> bookMapper.toBook(bookDto)).collect(Collectors.toList());*/
        else
        {
            bookRepository.deleteById(bookId);
            return true;
        }
    }
}
