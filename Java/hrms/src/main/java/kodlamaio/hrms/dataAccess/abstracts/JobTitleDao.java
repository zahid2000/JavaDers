package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
	boolean existsByTitle(String Title);
	
	JobTitle findById(int id);
	JobTitle findByTitle(String title);
}
