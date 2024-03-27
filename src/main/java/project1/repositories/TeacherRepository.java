package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project1.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	Teacher findByEmail(@Param(value = "email") String email);

}
