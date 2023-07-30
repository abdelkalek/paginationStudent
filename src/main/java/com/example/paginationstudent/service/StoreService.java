package com.example.paginationstudent.service;

import com.example.paginationstudent.models.CongifStoreParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 11/07/2023
 */
@Service
public class StoreService implements ICrudService<CongifStoreParam> {
    @Override
    public List<CongifStoreParam> getAll() {
        return null;
    }

    @Override
    public Page<CongifStoreParam> getPage(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<CongifStoreParam> findOne(UUID id) {
        return Optional.empty();
    }

    @Override
    public CongifStoreParam AddOne(CongifStoreParam todo) {
        return null;
    }

    @Override
    public CongifStoreParam update(CongifStoreParam congifStoreParam) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
