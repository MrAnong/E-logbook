package project1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project1.models.Authority;
import project1.repositories.AuthorityRepository;

@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	
	//to save an authority
	@Transactional
	public Authority save(Authority authority) {
		return authorityRepository.save(authority);
	}

}
