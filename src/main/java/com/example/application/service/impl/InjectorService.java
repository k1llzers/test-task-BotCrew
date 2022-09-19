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
public class InjectorService {
    private final DegreeService degreeService;
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public InjectorService(DegreeService degreeService,
                           DepartmentService departmentService, LectorService lectorService) {
        this.degreeService = degreeService;
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public void inject() {
        Degree assistant = new Degree("assistant");
        Degree associateProfessor = new Degree("associate professor");
        Degree professor = new Degree("professor");
        assistant = degreeService.save(assistant);
        associateProfessor = degreeService.save(associateProfessor);
        professor = degreeService.save(professor);
        Department it = new Department("it");
        it = departmentService.save(it);
        Department biology = new Department("biology");
        biology = departmentService.save(biology);
        Department psychology = new Department("psychology");
        psychology = departmentService.save(psychology);
        Department math = new Department("math");
        math = departmentService.save(math);
        Department physic = new Department("physic");
        physic = departmentService.save(physic);
        Lector ivanov = new Lector("Ivanov",assistant, List.of(biology,physic,psychology),200L);
        ivanov = lectorService.save(ivanov);
        Lector karpachov = new Lector("Karpachov",associateProfessor, List.of(it,math,physic),500L);
        karpachov = lectorService.save(karpachov);
        Lector hryhorenko = new Lector("Hryhorenko",professor,List.of(it,psychology,biology),1000L);
        hryhorenko = lectorService.save(hryhorenko);
        Lector tunda = new Lector("Tunda",associateProfessor,List.of(it,math),400L);
        tunda = lectorService.save(tunda);
        departmentService.update(it,hryhorenko);
        departmentService.update(biology,karpachov);
        departmentService.update(psychology,karpachov);
        departmentService.update(math,hryhorenko);
        departmentService.update(physic,tunda);
    }
}
