package com.demo.book.mapper;



import com.demo.book.BookDTO;
import com.demo.book.BookEntity;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(target="book_id",source="book_id")
    @Mapping(target="book_name",source="book_name")
    @Mapping(target="book_price",source="book_price")
    BookEntity toBook(BookDTO bookDTO);


    @Mapping(target="book_id",source="book_id")
    @Mapping(target="book_name",source="book_name")
    @Mapping(target="book_price",source="book_price")
    BookDTO toBookDTO(BookEntity book);
}
