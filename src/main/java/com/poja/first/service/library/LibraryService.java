package com.poja.first.service.library;

import com.poja.first.endpoint.rest.mapper.LibraryMapper;
import com.poja.first.endpoint.rest.validator.LibraryValidator;
import com.poja.first.model.exception.LibraryValidatorException;
import com.poja.first.model.exception.NotFoundException;
import com.poja.first.model.library.Library;
import com.poja.first.model.library.dto.request.CreateLibraryRequest;
import com.poja.first.model.library.dto.response.LibraryDTO;
import com.poja.first.repository.library.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryMapper libraryMapper;
    private final LibraryRepository libraryRepository;
    private final LibraryValidator libraryValidator;
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
    public List<LibraryDTO> searchLibraryByName(String keyword){
        return libraryRepository.findByNameContainingIgnoreCase(keyword)
                .stream().map(libraryMapper::toDTO)
                .toList();
    }
    public LibraryDTO createLibrary(CreateLibraryRequest request){
        if (libraryRepository.existsByNameIgnoreCase(request.getName())) {
            throw new LibraryValidatorException("Name already exists");
        }
        if(request.getPhone() != null && libraryRepository.existsByPhoneNumber(request.getPhone())){
            throw new LibraryValidatorException("Phone already exists");
        }
        Library library = libraryMapper.toEntity(request);
        libraryValidator.validate(library);
        return libraryMapper.toDTO(libraryRepository.save(library));
    }
}
