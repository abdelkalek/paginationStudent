package com.example.paginationstudent.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 27/03/2023
 */

public interface ICrudService<T> {
    List<T> getAll();
    Page<T> getPage(Pageable pageable);
    Optional<T>  findOne(UUID id);
    T AddOne(T todo);
    T update(T t);
    void deleteById(UUID id);
    default Integer sum(Integer a , Integer b ){
        return  a+b;
    }

}
