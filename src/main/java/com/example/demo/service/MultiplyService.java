package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplyService {
  public int multiply(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("A or B cannot be negative");
    }
    long result = (long) a * b;
    if (result > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Result exceeds integer bounds");
    }
    return (int) result;
  }
}
