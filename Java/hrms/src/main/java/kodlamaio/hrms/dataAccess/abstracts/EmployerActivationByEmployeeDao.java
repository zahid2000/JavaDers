package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerActivationByEmployee;

public interface EmployerActivationByEmployeeDao extends JpaRepository<EmployerActivationByEmployee, Integer> {
EmployerActivationByEmployee findByEmployee_Id(int employeeId);
EmployerActivationByEmployee findByEmployer_Id(int employerId);
EmployerActivationByEmployee findById(int Id);
}
