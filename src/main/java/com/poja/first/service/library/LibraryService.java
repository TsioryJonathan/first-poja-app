package com.poja.first.service.library;

import com.poja.first.endpoint.rest.mapper.LibraryMapper;
import com.poja.first.model.exception.NotFoundException;
import com.poja.first.model.library.Library;
import com.poja.first.model.library.dto.LibraryDTO;
import com.poja.first.repository.library.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryMapper libraryMapper;
    private final LibraryRepository libraryRepository;
    public List<LibraryDTO> getAllLibrary(){
        return libraryRepository.findAllWithBooks()
                .stream()
                .map(libraryMapper::toDTO)
                .toList();
    }
    public LibraryDTO getLibraryById(String libraryId){
        return libraryRepository.findById(libraryId)
                .map(libraryMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(String.format("Library with id %s not found", libraryId)));
    }
}
