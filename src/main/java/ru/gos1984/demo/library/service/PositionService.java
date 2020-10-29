package ru.gos1984.demo.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.gos1984.demo.library.entity.Position;
import ru.gos1984.demo.library.repository.PositionRepository;

import java.util.List;

public class PositionService implements MainService<Position> {
    
    private PositionRepository positionRepository;

    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Page<Position> getAll(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public Position findById(Long id) {
        //TODO: will change to orElseThrow
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public Position save(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }
}
