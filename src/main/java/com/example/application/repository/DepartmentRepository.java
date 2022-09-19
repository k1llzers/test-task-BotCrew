package com.example.application.repository;

import com.example.application.model.Department;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Transactional
    @Modifying
    @Query(value = "update Department d set d.head = :headId where d.id = :id",nativeQuery = true)
    void update(Long id,Long headId);

    Department findDepartmentByName(String name);
}
