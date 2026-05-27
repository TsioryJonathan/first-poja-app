package com.poja.first.model.library.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class LibraryDTO {
  private String id;
  private String name;
  private String address;
  private String phone;
  private List<BookDTO> books;
}
