package com.poja.first.model.library;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "library")
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String author;

  @Column(nullable = false, name = "release_year")
  private Integer releaseYear;

  @ManyToOne
  @JoinColumn(name = "id_library")
  @JsonIgnore
  private Library library;

  public Book(String title, String author, Integer releaseYear, Library library) {
    this.title = title;
    this.author = author;
    this.releaseYear = releaseYear;
    this.library = library;
  }
}
