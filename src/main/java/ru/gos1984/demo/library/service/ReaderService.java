package ru.gos1984.demo.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.gos1984.demo.library.entity.Reader;
import ru.gos1984.demo.library.repository.ReaderRepository;

import java.util.List;

@Service
public class ReaderService implements MainService<Reader> {

    private ReaderRepository readerRepository;

    @Autowired
    public void setReaderRepository(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    @Override
    public Page<Reader> getAll(Pageable pageable) {
        return readerRepository.findAll(pageable);
    }

    @Override
    public Reader findById(Long id) {
        //TODO: will change to orElseThrow
        return readerRepository.findById(id).orElse(null);
    }

    @Override
    public Reader save(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public void deleteById(Long id) {
        readerRepository.deleteById(id);
    }
}
