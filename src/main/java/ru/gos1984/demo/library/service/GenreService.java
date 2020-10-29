package ru.gos1984.demo.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.gos1984.demo.library.entity.Genre;
import ru.gos1984.demo.library.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService implements MainService<Genre> {

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Page<Genre> getAll(Pageable pageable) {
        return genreRepository.findAll(pageable);
    }

    @Override
    public Genre findById(Long id) {
        //TODO: will change to orElseThrow
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
