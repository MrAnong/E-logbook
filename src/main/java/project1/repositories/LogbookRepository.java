package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project1.models.Logbook;

@Repository
public interface LogbookRepository extends JpaRepository<Logbook, Long>{

}
