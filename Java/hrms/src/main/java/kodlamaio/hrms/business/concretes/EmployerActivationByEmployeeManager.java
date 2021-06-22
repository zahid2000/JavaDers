package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeEmployerService;
import kodlamaio.hrms.business.abstracts.EmployerActivationByEmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerActivationByEmployeeDao;
import kodlamaio.hrms.entities.concretes.ActivationCodeEmployer;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerActivationByEmployee;
import kodlamaio.hrms.entities.dtos.EmployerActivationByEmployeeDto;

@Service
public class EmployerActivationByEmployeeManager implements EmployerActivationByEmployeeService {

	private EmployerActivationByEmployeeDao employerActivationByEmployeeDao;
	private ActivationCodeEmployerService activationCodeEmployerService;
	private EmployerService employerService;

	@Autowired
	public EmployerActivationByEmployeeManager(EmployerActivationByEmployeeDao employerActivationByEmployeeDao,
			EmployerService employerService, ActivationCodeEmployerService activationCodeEmployerService) {
		super();
		this.employerActivationByEmployeeDao = employerActivationByEmployeeDao;
		this.activationCodeEmployerService = activationCodeEmployerService;
		this.employerService = employerService;
	}

	@Override
	public Result add(EmployerActivationByEmployeeDto employerActivationByEmployeeDto) {
		if (employerActivationByEmployeeDao
				.findByEmployer_Id(employerActivationByEmployeeDto.getEmployerId()) == null) {
			EmployerActivationByEmployee employerActivationByEmployee = new EmployerActivationByEmployee();
			Employee employee = new Employee();
			employee.setId(employerActivationByEmployeeDto.getEmployeeId());
			employerActivationByEmployee.setEmployee(employee);

			Employer employer = new Employer();
			employer.setId(employerActivationByEmployeeDto.getEmployerId());
			employerActivationByEmployee.setEmployer(employer);

			employerActivationByEmployee.setConfirmDate(employerActivationByEmployeeDto.getConfirmDate());
			employerActivationByEmployee.setConfirmed(true);

			this.employerActivationByEmployeeDao.save(employerActivationByEmployee);
			if(checkEmployerIsActived(employerActivationByEmployeeDto.getEmployerId())) {
				return new SuccessResult("Employer activated");
			}
			return new SuccessResult("Employer confirmed");
			
		} else {
			return new ErrorResult("Exists employer");
		}
	}

	@Override
	public DataResult<EmployerActivationByEmployee> findByEmployee_Id(int employeeId) {
		return new SuccessDataResult<EmployerActivationByEmployee>(
				this.employerActivationByEmployeeDao.findByEmployee_Id(employeeId));
	}

	@Override
	public DataResult<EmployerActivationByEmployee> findByEmployer_Id(int employerId) {
		return new SuccessDataResult<EmployerActivationByEmployee>(
				this.employerActivationByEmployeeDao.findByEmployer_Id(employerId));
	}

	@Override
	public DataResult<EmployerActivationByEmployee> findById(int Id) {
		return new SuccessDataResult<EmployerActivationByEmployee>(this.employerActivationByEmployeeDao.findById(Id));
	}

	@Override
	public DataResult<List<EmployerActivationByEmployee>> getAll() {
		return new SuccessDataResult<List<EmployerActivationByEmployee>>(
				this.employerActivationByEmployeeDao.findAll());
	}

	private boolean checkEmployerIsActived(int employerId) {
		ActivationCodeEmployer activationCodeEmployer = this.activationCodeEmployerService.getByEmployerId(employerId)
				.getData();

		if (activationCodeEmployer.isConfirmed()) {
			this.employerService.getById(employerId).getData().setActivated(true);
			return true;
		}
		return false;
		
	}
}
