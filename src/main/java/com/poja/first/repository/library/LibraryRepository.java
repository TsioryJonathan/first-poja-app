package com.poja.first.repository.library;

import com.poja.first.model.library.Library;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, String> {
  @Query("SELECT l FROM Library l")
  @EntityGraph(attributePaths = {"books"})
  List<Library> findAllWithBooks();

  List<Library> findByNameContainingIgnoreCase(String name);

  boolean existsByNameIgnoreCase(String name);

  boolean existsByPhoneNumber(String number);
}
