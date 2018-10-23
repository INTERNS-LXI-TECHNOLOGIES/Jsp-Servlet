package com.lxisoft.myjhipsterapp.service.mapper;

import com.lxisoft.myjhipsterapp.domain.*;
import com.lxisoft.myjhipsterapp.service.dto.BookDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Book and its DTO BookDTO.
 */
@Mapper(componentModel = "spring", uses = {AuthorMapper.class, PublisherMapper.class, CategoryMapper.class})
public interface BookMapper extends EntityMapper<BookDTO, Book> {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "publisher.id", target = "publisherId")
    BookDTO toDto(Book book);

    @Mapping(source = "authorId", target = "author")
    @Mapping(source = "publisherId", target = "publisher")
    Book toEntity(BookDTO bookDTO);

    default Book fromId(Long id) {
        if (id == null) {
            return null;
        }
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
