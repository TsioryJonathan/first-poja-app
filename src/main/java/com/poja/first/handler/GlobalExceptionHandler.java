package com.poja.first.handler;

import com.poja.first.model.exception.LibraryValidatorException;
import com.poja.first.model.exception.NegativeNumberException;
import com.poja.first.model.exception.NotFoundException;
import com.poja.first.model.exception.ZeroDivisionError;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException e) {
    Map<String, String> res = new HashMap<>();
    res.put("error", e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
  }

  @ExceptionHandler(LibraryValidatorException.class)
  public ResponseEntity<Map<String, String>> handleLibraryValidatorException(
      LibraryValidatorException e) {
    Map<String, String> res = new HashMap<>();
    res.put("error", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
  }

  @ExceptionHandler(ZeroDivisionError.class)
  public ResponseEntity<Map<String, String>> handleZeroDivisionError(ZeroDivisionError e) {
    Map<String, String> res = new HashMap<>();
    res.put("error", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
  }

  @ExceptionHandler(NegativeNumberException.class)
  public ResponseEntity<Map<String, String>> handleNegativeNumberException(
      NegativeNumberException e) {
    Map<String, String> res = new HashMap<>();
    res.put("error", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
  }
}
