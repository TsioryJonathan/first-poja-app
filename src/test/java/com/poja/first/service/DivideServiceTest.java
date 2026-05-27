package com.poja.first.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DivideServiceTest {
  @InjectMocks private DivideService divideService;

  @Test
  void should_divide_two_positive_numbers() {
    int a = 10;
    int b = 5;
    assertEquals(2, divideService.divide(a, b));
  }

  @Test
  void should_throw_an_error_if_one_is_negative() {
    int a = 10;
    int b = -5;
    assertThrows(IllegalArgumentException.class, () -> divideService.divide(a, b));
  }

  @Test
  void should_throw_an_error_if_b_is_zero() {
    int a = 10;
    int b = 0;
    assertThrows(IllegalArgumentException.class, () -> divideService.divide(a, b));
  }

  @Test
  void should_truncate_result_for_non_divisible_numbers() {
    int a = 10;
    int b = 3;
    assertEquals(3, divideService.divide(a, b));
  }

  @Test
  void should_return_zero_when_a_is_smaller_than_b() {
    int a = 3;
    int b = 10;
    assertEquals(0, divideService.divide(a, b));
  }
}
