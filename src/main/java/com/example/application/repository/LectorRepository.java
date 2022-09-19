package com.example.application.repository;

import com.example.application.model.Department;
import com.example.application.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    List<Lector> getLectorsByDepartments(Department department);

    List<Lector> findAllByNameLike(String regex);
}
