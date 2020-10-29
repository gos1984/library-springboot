package ru.gos1984.demo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gos1984.demo.library.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
