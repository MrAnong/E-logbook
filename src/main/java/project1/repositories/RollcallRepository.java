package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project1.models.Rollcall;

@Repository
public interface RollcallRepository extends JpaRepository<Rollcall, Long>{

}
