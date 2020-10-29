package ru.gos1984.demo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gos1984.demo.library.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
