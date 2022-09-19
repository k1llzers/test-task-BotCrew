package com.example.application.service.impl;

import com.example.application.service.DegreeService;
import com.example.application.service.DepartmentService;
import com.example.application.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final InjectorService injectorService;
    private final DegreeService degreeService;
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public GreetingService(InjectorService injectorService, DegreeService degreeService,
                           DepartmentService departmentService, LectorService lectorService) {
        this.injectorService = injectorService;
        this.degreeService = degreeService;
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public void greet() {
        injectorService.inject();
        System.out.println("hello! It`s university service. now you have: "
                + System.lineSeparator() + "Lectors: ");
        lectorService.getAll().forEach(System.out::println);
        System.out.println("Degrees: ");
        degreeService.getAll().forEach(System.out::println);
        System.out.println("Departments: ");
        departmentService.getAll().forEach(System.out::println);
    }
}
