package kodlamaio.hrms.business.validationRules.abstracts;

import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserValidatorService {
	    Result userNullCheck(User user);
	}

