package com.erp.sas.smartacademy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.erp.sas.smartacademy.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
