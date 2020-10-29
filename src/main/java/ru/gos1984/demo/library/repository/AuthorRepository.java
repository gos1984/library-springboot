package ru.gos1984.demo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gos1984.demo.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
