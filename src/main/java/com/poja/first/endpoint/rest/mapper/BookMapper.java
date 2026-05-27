package com.poja.first.endpoint.rest.mapper;

import com.poja.first.model.library.Book;
import com.poja.first.model.library.dto.BookDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookMapper {
    public BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .releaseYear(book.getReleaseYear())
                .build();
    }
}
