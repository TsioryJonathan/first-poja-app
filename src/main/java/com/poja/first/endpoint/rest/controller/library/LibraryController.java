package com.poja.first.endpoint.rest.controller.library;

import com.poja.first.model.library.Library;
import com.poja.first.model.library.dto.LibraryDTO;
import com.poja.first.service.library.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;
    @GetMapping
    public ResponseEntity<List<LibraryDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAllLibrary());
    }
}
