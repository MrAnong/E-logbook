package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project1.models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
