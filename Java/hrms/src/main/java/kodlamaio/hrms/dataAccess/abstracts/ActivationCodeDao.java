package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import kodlamaio.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer> {
	ActivationCode findById(int id);
}
