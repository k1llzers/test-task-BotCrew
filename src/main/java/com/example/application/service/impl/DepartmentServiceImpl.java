package com.example.application.service.impl;

import com.example.application.exceprion.DataProcessingException;
import com.example.application.model.Department;
import com.example.application.model.Lector;
import com.example.application.repository.DepartmentRepository;
import com.example.application.service.DepartmentService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void update(Department department,Lector head) {
        departmentRepository.update(department.getId(),head.getId());
    }

    @Override
    public Department get(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        }
        throw new DataProcessingException("Can`t find department by id: " + id);
    }

    @Override
    public Department get(String name) {
        return departmentRepository.findDepartmentByName(name);
    }
}
