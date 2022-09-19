package com.example.application.service.impl;

import com.example.application.model.Lector;
import com.example.application.service.DepartmentService;
import com.example.application.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class GettingHeadService {
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public GettingHeadService(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public Lector getHeadOfDepartment(String name) {
        Long headId = departmentService.get(name).getHead();
        return lectorService.get(headId);
    }
}
