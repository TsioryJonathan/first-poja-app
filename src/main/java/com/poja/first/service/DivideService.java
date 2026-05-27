package com.poja.first.service;

import com.poja.first.model.exception.NegativeNumberException;
import com.poja.first.model.exception.ZeroDivisionError;
import org.springframework.stereotype.Service;

@Service
public class DivideService {
  public double divide(double a, double b) {
    if (a < 0 || b < 0) {
      throw new NegativeNumberException("A or B cannot be negative");
    }
    if (b == 0) {
      throw new ZeroDivisionError();
    }
    return a / b;
  }
}
