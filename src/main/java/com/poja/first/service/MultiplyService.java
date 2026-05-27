package com.poja.first.service;

import com.poja.first.model.exception.NegativeNumberException;
import org.springframework.stereotype.Service;

@Service
public class MultiplyService {
  public double multiply(double a, double b) {
    if (a < 0 || b < 0) {
      throw new NegativeNumberException("A or B cannot be negative");
    }
    long result = (long) (a * b);
    if (result > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Result exceeds integer bounds");
    }
    return (double) result;
  }
}
