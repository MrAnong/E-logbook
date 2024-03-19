package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project1.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByMatricule(@Param(value = "matricule") String matricule);
	
	Student deleteByMatricule(@Param(value = "matricule") String matricule);

}
