package kodlamaio.hrms.business.validationRules.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.validationRules.abstracts.EmployerValidatorService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService{

	@Override
	public Result employerNullCheck(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result isEmailDomainCheck(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
