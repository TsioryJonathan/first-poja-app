package com.poja.first.endpoint.rest.controller.arith;

import com.poja.first.service.SubtractService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class SubtractController {
  private final SubtractService subtractService;

  @GetMapping("/subtract")
  public ResponseEntity<?> subtract(@RequestParam double a, @RequestParam double b) {
    try {
      double value = subtractService.subtract(a, b);
      Map<String, String> map = new HashMap<>();
      map.put("result", "Subtraction of " +  a + " and " + b + " is " + value);
      return ResponseEntity.status(HttpStatus.OK)
              .body(map);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
