package com.poja.first.model.library.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private Integer releaseYear;
}
