package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerActivationByEmployee;
import kodlamaio.hrms.entities.dtos.EmployerActivationByEmployeeDto;

public interface EmployerActivationByEmployeeService {
	DataResult<List<EmployerActivationByEmployee>> getAll();
	Result add(EmployerActivationByEmployeeDto employerActivationByEmployeeDto);
	DataResult<EmployerActivationByEmployee>  findByEmployee_Id(int employeeId);
	DataResult<EmployerActivationByEmployee> findByEmployer_Id(int employerId);
	DataResult<EmployerActivationByEmployee> findById(int Id);
}
