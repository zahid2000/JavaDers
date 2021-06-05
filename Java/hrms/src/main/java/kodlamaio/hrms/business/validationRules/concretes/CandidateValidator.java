package kodlamaio.hrms.business.validationRules.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.business.validationRules.abstracts.CandidateValidatorService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@Component
public class CandidateValidator extends UserValidator implements CandidateValidatorService {
    public Result candidateNullCheck(Candidate candidate) {
        String firstName = candidate.getFirstName();
        String lastName = candidate.getLastName();
        String tc = candidate.getNationalIdentity();
        LocalDate birth = candidate.getBirthDate();


        if (!super.userNullCheck(candidate).isSuccess() || (Strings.isNullOrEmpty(firstName)) ||
                (Strings.isNullOrEmpty(lastName)) || (Strings.isNullOrEmpty(tc)) || birth == null) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }

    @Override
    public Result nationalIdValid(String nationalIdentity) {
        if (nationalIdentity.length() == 11) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.nationalIdentityInvalid);
    }
}
