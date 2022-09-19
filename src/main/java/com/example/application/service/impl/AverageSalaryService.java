package com.example.application.service.impl;

import com.example.application.model.Lector;
import com.example.application.service.DepartmentService;
import com.example.application.service.LectorService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AverageSalaryService {
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public AverageSalaryService(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    public double getAverageSalary(String departmentName) {
        List<Lector> lectors
                = lectorService.getLectorsByDepartments(departmentService.get(departmentName));
        List<Long> salarys = lectors.stream()
                .map(lector -> lector.getSalary())
                .collect(Collectors.toList());
        double sumOfSalary = 0;
        for (Long salary:salarys) {
            sumOfSalary += salary.longValue();
        }
        return sumOfSalary / salarys.size();
    }
}
