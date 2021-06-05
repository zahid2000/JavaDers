package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ActivationCodeCandidate;

public interface ActivationCodeCandidateDao extends JpaRepository<ActivationCodeCandidate, Integer> {
	ActivationCodeCandidate findByCandidate_Id(int id);
}
