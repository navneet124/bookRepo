package com.demo.book.mapper;

import com.demo.book.BookDTO;
import com.demo.book.BookEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-13T17:51:37+0530",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity toBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setBook_price( bookDTO.getBook_price() );
        bookEntity.setBook_id( bookDTO.getBook_id() );
        bookEntity.setBook_name( bookDTO.getBook_name() );

        return bookEntity;
    }

    @Override
    public BookDTO toBookDTO(BookEntity book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setBook_price( book.getBook_price() );
        bookDTO.setBook_id( book.getBook_id() );
        bookDTO.setBook_name( book.getBook_name() );

        return bookDTO;
    }
}
