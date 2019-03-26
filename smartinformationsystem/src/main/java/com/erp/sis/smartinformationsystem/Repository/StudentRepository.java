package com.erp.sis.smartinformationsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.sis.smartinformationsystem.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
}

