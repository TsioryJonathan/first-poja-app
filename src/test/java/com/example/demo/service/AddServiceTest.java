package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddServiceTest {
  private AddService addService;

  @BeforeEach
  void setup() {
    addService = new AddService();
  }

  @Test
  void should_add_two_positive_number() {
    int a = 10;
    int b = 50;
    assertEquals(60, addService.add(a, b));
  }

  @Test
  void should_throw_an_error_if_one_is_negative() {
    int a = 10;
    int b = -5;
    assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
  }
}
