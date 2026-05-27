package com.poja.first.service;

import static org.junit.jupiter.api.Assertions.*;

import com.poja.first.model.exception.NegativeNumberException;
import com.poja.first.model.exception.ZeroDivisionError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DivideServiceTest {
  @InjectMocks private DivideService divideService;

  @Test
  void should_divide_two_positive_numbers() {
    double a = 10;
    double b = 5;
    assertEquals(2, divideService.divide(a, b));
  }

  @Test
  void should_throw_an_error_if_one_is_negative() {
    double a = 10;
    double b = -5;
    assertThrows(NegativeNumberException.class, () -> divideService.divide(a, b));
  }

  @Test
  void should_throw_an_error_if_b_is_zero() {
    double a = 10;
    double b = 0;
    assertThrows(ZeroDivisionError.class, () -> divideService.divide(a, b));
  }

  @Test
  void should_truncate_result_for_non_divisible_numbers() {
    double a = 10;
    double b = 3;
    assertEquals(3, divideService.divide(a, b));
  }
}
