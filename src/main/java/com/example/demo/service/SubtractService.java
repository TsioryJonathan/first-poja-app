package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SubtractService {
  public int subtract(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("A or B cannot be negative");
    }
    return a - b;
  }
}
