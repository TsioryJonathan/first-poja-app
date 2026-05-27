package com.poja.first.endpoint.rest.validator;

import com.poja.first.model.exception.LibraryValidatorException;
import com.poja.first.model.library.Library;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LibraryValidator {
  public void validate(Library library) {
    if (library == null) {
      throw new LibraryValidatorException("Library cannot be null");
    }

    if (library.getName() == null || library.getName().trim().isEmpty()) {
      throw new LibraryValidatorException("Library name is required");
    }

    if (library.getAddress() == null || library.getAddress().trim().isEmpty()) {
      throw new LibraryValidatorException("Library address is required");
    }

    if (library.getPhoneNumber() == null || library.getPhoneNumber().trim().isEmpty()) {
      throw new LibraryValidatorException("Library phone number is required");
    }

    String phone = library.getPhoneNumber().replaceAll("[\\s\\-]", "");
    if (!phone.matches("^[0-9]+$")) {
      throw new LibraryValidatorException(
          "Library phone number must contain only digits, spaces, or dashes");
    }
  }
}
