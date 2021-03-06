package kodlamaio.hrms.business.validationRules.concretes;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.business.validationRules.abstracts.EmployerValidatorService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService {

	public Result employerNullCheck(Employer employer) {
		String companyName = employer.getCompanyName();
		String webAddress = employer.getWebAddress();
		String phoneNumber = employer.getPhoneNumber();

		if (!super.userNullCheck(employer).isSuccess() || Strings.isNullOrEmpty(companyName)
				|| Strings.isNullOrEmpty(webAddress) || Strings.isNullOrEmpty(phoneNumber)) {
			return new ErrorResult(Messages.notNull);
		}
		return new SuccessResult();
	}

	public Result isEmailDomainCheck(Employer employer) {
		String email = employer.getEmail();
		String webAddress = employer.getWebAddress();

		String domain = webAddress.split("www.")[1];
		if (domain.equals(email.split("@")[1])) {
			return new SuccessResult();
		}
		return new ErrorResult("Domain geçersiz");
	}
}