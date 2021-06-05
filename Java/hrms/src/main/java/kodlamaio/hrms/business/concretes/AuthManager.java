package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeCandidateDao;
import kodlamaio.hrms.entities.concretes.ActivationCodeCandidate;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterCandidateDto;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private UserService userService;
	private ActivationCodeCandidateDao activationCodeCandidateDao;

	@Autowired
	public AuthManager(ActivationCodeCandidateDao activationCodeCandidateDao, CandidateService candidateService,UserService userService) {
		super();
		this.candidateService = candidateService;
		this.activationCodeCandidateDao = activationCodeCandidateDao;
		this.userService=userService;
	}

	@Override
	public Result login(String email, String password) {
		User user = new User();
		user = userService.getByEmail(email).getData();
		if (user.getPassword().equals(password)) {
			return new SuccessResult(Messages.loginSuccess);
		}
		return new ErrorResult(Messages.loginFailed);
	}

	@Override
	public Result registerCandiate(RegisterCandidateDto registerCandidateDto) {
		if (checkIfEqualPassword(registerCandidateDto.getPassword(), registerCandidateDto.getRePassword())) {
			Candidate candidate = new Candidate(registerCandidateDto.getFirstName(), registerCandidateDto.getLastName(),
					registerCandidateDto.getNationalIdentity(), registerCandidateDto.getBirthDate());
			candidate.setEmail(registerCandidateDto.getEmail());
			candidate.setPassword(registerCandidateDto.getPassword());
			return this.candidateService.add(candidate);
		}
		return new ErrorResult(Messages.PasswordNotConfirmed);
	}

	@Override
	public Result registerEmployer(Employer employer) {
		return null;

	}

	@Override
	public Result verifyCandidate(String activationCode, int userId) {
		ActivationCodeCandidate activationCodeCandidate = new ActivationCodeCandidate();
		activationCodeCandidate = this.activationCodeCandidateDao.findByCandidate_Id(userId);
		activationCodeCandidate.setConfirmed(true);
		this.activationCodeCandidateDao.save(activationCodeCandidate);
		return new SuccessResult(Messages.candidateVerified);

	}

	@Override
	public Result verifyEmployer(String activationCode, int userId) {
		return null;

	}

	private boolean checkIfEqualPassword(String password, String rePassword) {
		if (password.equals(rePassword)) {
			return true;
		}
		return false;
	}

}
