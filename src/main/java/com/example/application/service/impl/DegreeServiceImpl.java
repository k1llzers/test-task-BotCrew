package com.example.application.service.impl;

import com.example.application.exceprion.DataProcessingException;
import com.example.application.model.Degree;
import com.example.application.repository.DegreeRepository;
import com.example.application.service.DegreeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository degreeRepository;

    public DegreeServiceImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public Degree save(Degree degree) {
        return degreeRepository.save(degree);
    }

    @Override
    public List<Degree> getAll() {
        return degreeRepository.findAll();
    }

    @Override
    public Degree get(Long id) {
        Optional<Degree> degree = degreeRepository.findById(id);
        if (degree.isPresent()) {
            return degree.get();
        }
        throw new DataProcessingException("Can`t find degree by id: " + id);
    }
}
