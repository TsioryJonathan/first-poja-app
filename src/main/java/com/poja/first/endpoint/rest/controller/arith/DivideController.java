package com.poja.first.endpoint.rest.controller.arith;

import com.poja.first.service.DivideService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DivideController {
  private final DivideService divideService;

  @GetMapping("/divide")
  public ResponseEntity<?> divide(@RequestParam int a, @RequestParam int b) {
    try {
      int value = divideService.divide(a, b);
      return ResponseEntity.status(HttpStatus.OK)
          .body("Compute value of" + a + " and" + b + "is " + value);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
