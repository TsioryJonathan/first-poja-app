package com.poja.first.service;

import org.springframework.stereotype.Service;

@Service
public class DivideService {
  public int divide(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("A or B cannot be negative");
    }
    if (b == 0) {
      throw new IllegalArgumentException("B cannot be zero");
    }
    return a / b;
  }
}
