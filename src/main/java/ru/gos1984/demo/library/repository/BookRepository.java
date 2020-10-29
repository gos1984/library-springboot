package ru.gos1984.demo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gos1984.demo.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
