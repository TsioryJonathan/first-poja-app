package com.poja.first.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MultiplyServiceTest {
  @InjectMocks private MultiplyService multiplyService;

  @Test
  void should_multiply_two_positive_numbers() {
    int a = 10;
    int b = 50;
    assertEquals(500, multiplyService.multiply(a, b));
  }

  @Test
  void should_throw_an_error_if_one_is_negative() {
    int a = 10;
    int b = -5;
    assertThrows(IllegalArgumentException.class, () -> multiplyService.multiply(a, b));
  }

  @Test
  void should_throw_an_error_if_result_overflows() {
    int a = Integer.MAX_VALUE;
    int b = 2;
    assertThrows(IllegalArgumentException.class, () -> multiplyService.multiply(a, b));
  }

  @Test
  void should_return_zero_when_multiplying_by_zero() {
    assertEquals(0, multiplyService.multiply(0, 100));
    assertEquals(0, multiplyService.multiply(100, 0));
  }
}
