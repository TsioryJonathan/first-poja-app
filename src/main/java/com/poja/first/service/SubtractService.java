package com.poja.first.service;

import com.poja.first.model.exception.NegativeNumberException;
import org.springframework.stereotype.Service;

@Service
public class SubtractService {
  public double subtract(double a, double b) {
    if (a < 0 || b < 0) {
      throw new NegativeNumberException("A or B cannot be negative");
    }
    return a - b;
  }
}
