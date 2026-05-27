package com.poja.first.endpoint.rest.controller.library;

import com.poja.first.model.library.dto.request.CreateLibraryRequest;
import com.poja.first.model.library.dto.response.LibraryDTO;
import com.poja.first.service.library.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.getLibraryById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<LibraryDTO>> searchLibrary(@RequestParam String keyword){
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.searchLibraryByName(keyword));
    }
    @PostMapping("/create")
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody CreateLibraryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.createLibrary(request));
    }
}
