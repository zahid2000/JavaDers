package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerActivationByEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerActivationByEmployee;
import kodlamaio.hrms.entities.dtos.EmployerActivationByEmployeeDto;

@RestController
@RequestMapping("api/EmployersActivationByEmployees/")
public class EmployersActivationByEmployeesController {

	private EmployerActivationByEmployeeService employerActivationByEmployeeService;

	@Autowired
	public EmployersActivationByEmployeesController(
			EmployerActivationByEmployeeService employerActivationByEmployeeService) {
		super();
		this.employerActivationByEmployeeService = employerActivationByEmployeeService;
	}

	@GetMapping("getAll")
	public DataResult<List<EmployerActivationByEmployee>> getAll() {
		return this.employerActivationByEmployeeService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody EmployerActivationByEmployeeDto employerActivationByEmployeeDto) {
		return this.employerActivationByEmployeeService.add(employerActivationByEmployeeDto);
	}
	@GetMapping("findByEmployee_Id")
	public DataResult<EmployerActivationByEmployee> findByEmployee_Id(int employeeId){
		return this.employerActivationByEmployeeService.findByEmployee_Id(employeeId);
	}

	@GetMapping("findByEmployer_Id")
	public DataResult<EmployerActivationByEmployee> findByEmployer_Id(int employerId){
		return this.employerActivationByEmployeeService.findByEmployer_Id(employerId);
	}
	@GetMapping("findById")
	public DataResult<EmployerActivationByEmployee> findById(int Id){
		return this.employerActivationByEmployeeService.findById(Id);
	}
}
