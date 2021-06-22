package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeEmployerService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.business.validationRules.abstracts.EmployerValidatorService;
import kodlamaio.hrms.core.business.BusinessEngine;
import kodlamaio.hrms.core.utilities.activations.CodeGenerator;
import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ActivationCodeEmployer;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.ActivationCodeCandidateDto;
import kodlamaio.hrms.entities.dtos.ActivationCodeEmployerDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private ActivationCodeEmployerService activationCodeEmployerService;
	private UserService userService;
	private EmployerValidatorService employerValidatorService;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ActivationCodeEmployerService activationCodeEmployerService,
			EmailService emailService, UserService userService, EmployerValidatorService employerValidatorService) {
		super();
		this.employerDao = employerDao;
		this.activationCodeEmployerService = activationCodeEmployerService;
		this.userService = userService;
		this.employerValidatorService = employerValidatorService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.employersListed);
	}

	@Override
	public Result add(Employer employer) {
		Result result = BusinessEngine.run(employerValidatorService.employerNullCheck(employer)/*,
				employerValidatorService.isEmailDomainCheck(employer), checkIfEmailExists(employer.getEmail())*/);
		if (!result.isSuccess()) {
			return result;
		}
		this.employerDao.save(employer);
		this.activationCodeEmployerService.add(createActivationCode(employer));
		String message = this.emailService.sendEmail(employer.getEmail(),
				createActivationCode(employer).getActivationCode());
		return new SuccessResult(Messages.employerAdded + ".Activation code: " + message);
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id), Messages.employersListed);
	}

	@Override
	public DataResult<Employer> findByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}

	@Override
	public DataResult<Employer> findByCompanyName(String companyName) {
		return new SuccessDataResult<Employer>(this.employerDao.findByCompanyName(companyName));
	}

	private ActivationCodeEmployerDto createActivationCode(Employer employer) {
		ActivationCodeEmployerDto activationCodeEmployerDto = new ActivationCodeEmployerDto();
		activationCodeEmployerDto.setUserId(employer.getId());
		activationCodeEmployerDto.setActivationCode(CodeGenerator.codeGenerator());
		return activationCodeEmployerDto;
	}

	private Result checkIfEmailExists(String email) {
		if (this.userService.userExists(email)) {
			return new ErrorResult(Messages.emailExist);
		}
		return new SuccessResult();
	}
}
