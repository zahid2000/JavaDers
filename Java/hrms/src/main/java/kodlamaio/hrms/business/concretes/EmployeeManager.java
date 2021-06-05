package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.core.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager  implements EmployeeService {

	private EmployeeDao employeeDao;
	private UserDao userDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, UserDao userDao) {
		super();
		this.employeeDao = employeeDao;
		this.userDao = userDao;
	}

	

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),Messages.employeesListed);
	}

	@Override
	public Result add(Employee employee) {
		if(userDao.existsByEmail(employee.getEmail())) {
			return new ErrorResult(Messages.emailExist);
		}
		this.employeeDao.save(employee);
		return new SuccessResult(Messages.EmployeeAdded);
	}

	@Override
	public DataResult<Employee> findById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.findById(id));
	}

	@Override
	public DataResult<Employee> findByFirstName(String firstName) {
		return new SuccessDataResult<Employee>(this.employeeDao.findByFirstName(firstName));
	}

}
