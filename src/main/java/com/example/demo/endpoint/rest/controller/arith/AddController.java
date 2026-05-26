package com.example.demo.endpoint.rest.controller.arith;

import com.example.demo.service.AddService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AddController {
  private final AddService addService;

  @GetMapping("/add")
  public ResponseEntity<?> add(@RequestParam int a, @RequestParam int b) {
    try {
      int value = addService.add(a, b);
      return ResponseEntity.status(HttpStatus.OK)
          .body("Compute value of" + a + " and" + b + "is " + value);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
