package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ActivationCodeEmployer;

public interface ActivationCodeEmployerDao extends JpaRepository<ActivationCodeEmployer, Integer> {
	
}
