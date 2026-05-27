package com.poja.first.service;

import static org.junit.jupiter.api.Assertions.*;

import com.poja.first.model.exception.NegativeNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddServiceTest {
  @InjectMocks private AddService addService;

  @Test
  void should_add_two_positive_number() {
    double a = 10d;
    double b = 50d;
    assertEquals(60, addService.add(a, b));
  }

  @Test
  void should_throw_an_error_if_one_is_negative() {
    double a = 10;
    double b = -5;
    assertThrows(NegativeNumberException.class, () -> addService.add(a, b));
  }
}
