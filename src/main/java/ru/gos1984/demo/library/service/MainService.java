package ru.gos1984.demo.library.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MainService<T> {

    List<T> getAll();
    Page<T> getAll(Pageable pageable);
    T findById(Long id);
    T save(T t);
    void deleteById(Long id);
}
