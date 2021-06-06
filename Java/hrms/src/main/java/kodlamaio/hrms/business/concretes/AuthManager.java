package kodlamaio.hrms.business.concretes;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeCandidateService;
import kodlamaio.hrms.business.abstracts.ActivationCodeEmployerService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeCandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeEmployerDao;
import kodlamaio.hrms.entities.concretes.ActivationCodeCandidate;
import kodlamaio.hrms.entities.concretes.ActivationCodeEmployer;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private UserService userService;
	private ActivationCodeCandidateDao activationCodeCandidateDao;
	private EmployerService employerService;
	private ActivationCodeEmployerService activationCodeEmployerService;
	private ActivationCodeCandidateService activationCodeCandidateService;

	@Autowired
	public AuthManager(ActivationCodeCandidateDao activationCodeCandidateDao,ActivationCodeEmployerService activationCodeEmployerService,ActivationCodeCandidateService activationCodeCandidateService, CandidateService candidateService,EmployerService employerService,
			UserService userService) {
		super();
		this.candidateService = candidateService;
		this.activationCodeCandidateDao = activationCodeCandidateDao;
		this.userService = userService;
		this.employerService=employerService;
		this.activationCodeCandidateService=activationCodeCandidateService;
		this.activationCodeEmployerService=activationCodeEmployerService;
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
	public Result registerEmployer(RegisterForEmployerDto registerForEmployerDto) {
		if (checkIfEqualPassword(registerForEmployerDto.getPassword(), registerForEmployerDto.getRePassword())) {
			Employer employer = new Employer(registerForEmployerDto.getCompanyName(),
					registerForEmployerDto.getWebAddress(), registerForEmployerDto.getPhoneNumber(),false);
			employer.setEmail(registerForEmployerDto.getEmail());
			employer.setPassword(registerForEmployerDto.getPassword());
			return employerService.add(employer);
			
		}
		return new ErrorResult(Messages.PasswordNotConfirmed);

	}

	@Override
	public Result verifyCandidate(String activationCode, int userId) {
		return this.activationCodeCandidateService.verify(activationCode, userId);

	}

	@Override
	public Result verifyEmployer(String activationCode, int userId) {
		return this.activationCodeEmployerService.verify(activationCode, userId);
		

	}

	private boolean checkIfEqualPassword(String password, String rePassword) {
		if (password.equals(rePassword)) {
			return true;
		}
		return false;
	}

}
