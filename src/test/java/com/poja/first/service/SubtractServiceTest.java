package com.poja.first.service;

import static org.junit.jupiter.api.Assertions.*;

import com.poja.first.model.exception.NegativeNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SubtractServiceTest {
  @InjectMocks private SubtractService subtractService;

  @Test
  void should_subtract_two_positive_numbers() {
    double a = 50;
    double b = 10;
    assertEquals(40, subtractService.subtract(a, b));
  }

  @Test
  void should_throw_an_error_if_a_is_negative() {
    double a = -10;
    double b = 5;
    assertThrows(NegativeNumberException.class, () -> subtractService.subtract(a, b));
  }

  @Test
  void should_throw_an_error_if_b_is_negative() {
    double a = 10;
    double b = -5;
    assertThrows(NegativeNumberException.class, () -> subtractService.subtract(a, b));
  }
}
