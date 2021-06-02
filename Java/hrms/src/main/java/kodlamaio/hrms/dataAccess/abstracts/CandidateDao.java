package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	boolean existsByEmail(String email);
	Candidate findById(int id);
	List<Candidate> findByEmail(String email);
	Candidate findByNationalIdentity(String nationalIdentity);
	
	
}
