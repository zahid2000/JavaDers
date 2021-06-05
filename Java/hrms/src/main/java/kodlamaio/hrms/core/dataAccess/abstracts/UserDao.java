package kodlamaio.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entity.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);
	User findByEmail(String email);
}
