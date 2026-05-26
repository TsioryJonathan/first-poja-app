package com.example.demo.conf;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.service.AddService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTest {
  private AddService addService;

  @BeforeEach
  void setup() {
    addService = new AddService();
  }

  @Test
  void addOk() {
    int a = 10;
    int b = 50;
    assertEquals(60, addService.add(a, b));
  }

  @Test
  void addFail() {
    int a = 10;
    int b = -5;
    assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
  }

  @Test
  void addNotEqual() {
    int a = 10;
    int b = 50;
    assertNotEquals(70, addService.add(a, b));
  }
}
