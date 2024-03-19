package project1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project1.models.Student;
import project1.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
//	Optional<javax.security.auth.Subject> findByCode(@Param(value = "code") String code);
//
//	javax.security.auth.Subject save(javax.security.auth.Subject subject);
	
	Subject findByCode(@Param(value = "code") String code);
	
	Subject deleteByCode(@Param(value = "code") String code);



}
