package project1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project1.models.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

	Optional<Classroom> save(Optional<Classroom> classroom);

}
