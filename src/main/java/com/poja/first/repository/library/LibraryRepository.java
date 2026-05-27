package com.poja.first.repository.library;

import com.poja.first.model.library.Library;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, String> {
    Optional<Library> findByName(String name);

    @Query("SELECT l FROM Library l")
    @EntityGraph(attributePaths = {"books"})
    List<Library> findAllWithBooks();
}
