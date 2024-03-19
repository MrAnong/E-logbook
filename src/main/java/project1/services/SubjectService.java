package project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project1.models.Subject;
import project1.repositories.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
//	1- find a single subject record from the database
	@Transactional
	public Optional<Subject> getOne (String code) {
		Subject subject = subjectRepository.findByCode(code);
		if(subject == null) {
			return Optional.empty();
		}
		return Optional.of(subject);
	}
	
	//2- find the list of all subjects from the database
		@Transactional
		public List<Subject> getAll(){
			return  subjectRepository.findAll();
		}
		
		//3- save a single subject record
		@Transactional
		public Subject saveOne(Subject subject) {
			return subjectRepository.save(subject);
		}
		
		//4- save a list of subjects in the database
		@Transactional
		public List<Subject> saveList(List<Subject> subjectList){
			for(Subject subject1: subjectList) {
				subjectList.add(subjectRepository.save(subject1));
			}
			return subjectList;
		}
		
		//5- delete a single subject record from the database
		@Transactional
		public Optional<Subject> deleteOne(String code){
			Subject foundSubject = subjectRepository.findByCode(code);
			if(foundSubject == null) {
				return Optional.empty();
			}
			subjectRepository.deleteByCode(code);
			return Optional.of(foundSubject);
		}
		
		//6- delete a list of subjects from the database
		@Transactional
		public Optional<List<Subject>> deleteList(List<Subject> subjectList){
			List<Subject> newList = subjectList;
			for(Subject subject1: subjectList) {
				Subject foundSubject = subjectRepository.findByCode(subject1.getCode());
				if(foundSubject == null) {
					return Optional.empty();
					}
				newList.add(subject1);
				subjectRepository.deleteByCode(subject1.getCode());
			}
			return Optional.of(newList);
			
		}

		
		//7- update a subject record in the database
		@Transactional
		public Optional<Subject> updateOne(Subject subject){
			Subject foundSubject = subjectRepository.findByCode(subject.getCode());
			if(foundSubject == null) {
				return Optional.empty();
			}
			subjectRepository.save(subject);
			return Optional.of(subject);
			
		}
	
}