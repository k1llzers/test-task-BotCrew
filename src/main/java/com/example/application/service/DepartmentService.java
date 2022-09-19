package com.example.application.service;

import com.example.application.model.Department;
import com.example.application.model.Lector;
import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    List<Department> getAll();

    void update(Department department,Lector head);

    Department get(Long id);

    Department get(String name);
}
