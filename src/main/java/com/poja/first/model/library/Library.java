package com.poja.first.model.library;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
@Getter
@Setter
@EqualsAndHashCode(exclude = "books")
@Builder
public class Library {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String address;

  @Column(name = "phone_number")
  private String phoneNumber;

  public Library(String name, String address, String phoneNumber) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
  private List<Book> books;

  public void addBook(Book book) {
    books.add(book);
    book.setLibrary(this);
  }

  public void removeBook(Book book) {
    books.remove(book);
    book.setLibrary(null);
  }
}
