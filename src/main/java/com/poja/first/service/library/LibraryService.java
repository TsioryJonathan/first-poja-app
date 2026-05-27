package com.poja.first.service.library;

import com.poja.first.model.exception.NotFoundException;
import com.poja.first.model.library.Library;
import com.poja.first.repository.library.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    public List<Library> getAllLibrary(){
        return libraryRepository.findAll();
    }
    public Library getLibraryById(String libraryId){
        return libraryRepository.findById(libraryId)
                .orElseThrow(() -> new NotFoundException(String.format("Library with id %s not found", libraryId)));
    }
}
