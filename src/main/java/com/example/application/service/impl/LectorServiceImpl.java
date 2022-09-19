package com.example.application.service.impl;

import com.example.application.exceprion.DataProcessingException;
import com.example.application.model.Department;
import com.example.application.model.Lector;
import com.example.application.repository.LectorRepository;
import com.example.application.service.LectorService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector save(Lector lector) {
        return lectorRepository.save(lector);
    }

    @Override
    public List<Lector> getAll() {
        return lectorRepository.findAll();
    }

    @Override
    public Lector get(Long id) {
        Optional<Lector> lector = lectorRepository.findById(id);
        if (lector.isPresent()) {
            return lector.get();
        }
        throw new DataProcessingException("Can`t find lector by id: " + id);
    }

    @Override
    public List<Lector> getLectorsByDepartments(Department department) {
        return lectorRepository.getLectorsByDepartments(department);
    }

    @Override
    public List<Lector> getLectorsByNameLike(String regex) {
        return lectorRepository.findAllByNameLike(regex);
    }
}
