package com.poja.first.endpoint.rest.controller.arith;

import com.poja.first.service.DivideService;
import java.util.HashMap;
import java.util.Map;
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
  public ResponseEntity<?> divide(@RequestParam double a, @RequestParam double b) {
    try {
      double value = divideService.divide(a, b);
      Map<String, String> map = new HashMap<>();
      map.put("result", "Division of " + a + " and " + b + " is " + value);
      return ResponseEntity.status(HttpStatus.OK).body(map);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
