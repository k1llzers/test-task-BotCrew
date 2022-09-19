package com.example.application.service.impl;

import com.example.application.service.DepartmentService;
import com.example.application.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class CountOfEmployeeService {
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public CountOfEmployeeService(LectorService lectorService,
                                  DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    public int getCount(String departmentName) {
        return lectorService.getLectorsByDepartments(departmentService.get(departmentName)).size();
    }
}
