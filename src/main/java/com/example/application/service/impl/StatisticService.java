package com.example.application.service.impl;

import com.example.application.model.Degree;
import com.example.application.model.Department;
import com.example.application.model.Lector;
import com.example.application.service.DegreeService;
import com.example.application.service.DepartmentService;
import com.example.application.service.LectorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {
    private final LectorService lectorService;
    private final DepartmentService departmentService;
    private final DegreeService degreeService;

    public StatisticService(LectorService lectorService,
                            DepartmentService departmentService, DegreeService degreeService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
        this.degreeService = degreeService;
    }

    public String getStatistic(String departmentName) {
        StringBuilder sb = new StringBuilder();
        Department department = departmentService.get(departmentName);
        List<Degree> degrees = degreeService.getAll();
        List<Lector> lectors = lectorService.getLectorsByDepartments(department);
        long countOfLectors = lectors.stream()
                .filter((lector -> lector.getDegree().equals(degrees.get(0))))
                .count();
        sb.append(degrees.get(0).getName())
                .append(" - ")
                .append(countOfLectors)
                .append(System.lineSeparator());
        countOfLectors = lectors.stream()
                .filter((lector -> lector.getDegree().equals(degrees.get(1))))
                .count();
        sb.append(degrees.get(1).getName())
                .append(" - ")
                .append(countOfLectors)
                .append(System.lineSeparator());
        countOfLectors = lectors.stream()
                .filter((lector -> lector.getDegree().equals(degrees.get(2))))
                .count();
        sb.append(degrees.get(2).getName())
                .append(" - ").append(countOfLectors)
                .append(System.lineSeparator());
        return sb.toString();
    }
}
