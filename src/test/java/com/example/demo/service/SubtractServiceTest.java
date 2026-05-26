package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SubtractServiceTest {
  @InjectMocks private SubtractService subtractService;

  @Test
  void should_subtract_two_positive_numbers() {
    int a = 50;
    int b = 10;
    assertEquals(40, subtractService.subtract(a, b));
  }

  @Test
  void should_throw_an_error_if_a_is_negative() {
    int a = -10;
    int b = 5;
    assertThrows(IllegalArgumentException.class, () -> subtractService.subtract(a, b));
  }

  @Test
  void should_throw_an_error_if_b_is_negative() {
    int a = 10;
    int b = -5;
    assertThrows(IllegalArgumentException.class, () -> subtractService.subtract(a, b));
  }

  @Test
  void should_return_negative_result_when_b_is_greater_than_a() {
    int a = 10;
    int b = 50;
    assertEquals(-40, subtractService.subtract(a, b));
  }
}
