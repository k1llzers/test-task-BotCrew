package com.example.application.service;

import com.example.application.model.Degree;
import java.util.List;

public interface DegreeService {
    Degree save(Degree degree);

    List<Degree> getAll();

    Degree get(Long id);
}
