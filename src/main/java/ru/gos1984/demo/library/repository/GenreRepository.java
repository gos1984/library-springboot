package ru.gos1984.demo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gos1984.demo.library.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
