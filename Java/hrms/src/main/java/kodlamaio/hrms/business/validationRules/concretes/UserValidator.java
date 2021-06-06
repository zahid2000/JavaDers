package kodlamaio.hrms.business.validationRules.concretes;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Component
public class UserValidator {
	 public Result userNullCheck(User user) {

	        if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getPassword())) {
	            return new ErrorResult(Messages.notNull);
	        }
	        return new SuccessResult();
	    }
}
