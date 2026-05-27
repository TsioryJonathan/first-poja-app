package com.poja.first.endpoint.rest.mapper;

import com.poja.first.model.library.Library;
import com.poja.first.model.library.dto.request.CreateLibraryRequest;
import com.poja.first.model.library.dto.response.LibraryDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LibraryMapper {

    private final BookMapper bookMapper;
    public LibraryDTO toDTO(Library library) {
        return LibraryDTO.builder()
                .id(library.getId())
                .name(library.getName())
                .phone(library.getPhoneNumber())
                .address(library.getAddress())
                .books(library.getBooks() != null ? library.getBooks().stream().map(bookMapper::toDTO).toList(): List.of())
                .build();
    }

    public Library toEntity(CreateLibraryRequest request) {
        return Library.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phoneNumber(request.getPhone())
                .build();
    }
}
