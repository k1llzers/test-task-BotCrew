package com.example.application.service;

import com.example.application.model.Department;
import com.example.application.model.Lector;
import java.util.List;

public interface LectorService {
    Lector save(Lector lector);

    List<Lector> getAll();

    Lector get(Long id);

    List<Lector> getLectorsByDepartments(Department department);

    List<Lector> getLectorsByNameLike(String regex);
}
