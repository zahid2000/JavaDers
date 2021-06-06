package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeCandidateService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.business.validationRules.abstracts.CandidateValidatorService;
import kodlamaio.hrms.core.business.BusinessEngine;
import kodlamaio.hrms.core.utilities.activations.CodeGenerator;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CheckRealPersonService;
import kodlamaio.hrms.core.utilities.adapters.models.MernisPerson;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.ActivationCodeCandidateDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserService userService;
	private CheckRealPersonService checkRealPersonService;
	private CandidateValidatorService candidateValidatorService;
	private ActivationCodeCandidateService activationCodeCandidateService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserService userService,
			CheckRealPersonService checkRealPersonService, CandidateValidatorService candidateValidatorService,ActivationCodeCandidateService activationCodeCandidateService) {
		super();
		this.candidateDao = candidateDao;
		this.userService = userService;
		this.checkRealPersonService = checkRealPersonService;
		this.candidateValidatorService = candidateValidatorService;
		this.activationCodeCandidateService=activationCodeCandidateService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Messages.candidatesListed);
	}

	@Override
	public Result add(Candidate candidate) {
		Result result = BusinessEngine.run(isIdentityNumberExist(candidate.getNationalIdentity()),
				isMernisVerified(candidate), candidateValidatorService.candidateNullCheck(candidate),
				candidateValidatorService.nationalIdValid(candidate.getNationalIdentity()),
				checkIfEmailExists(candidate.getEmail()));
		if (!result.isSuccess()) {
			return result;
		}
		this.candidateDao.save(candidate);
		this.activationCodeCandidateService.add(createActivationCode(candidate));
		return new SuccessResult(Messages.candidateAdded);
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id));
	}

	@Override
	public DataResult<List<Candidate>> getByEmail(String email) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalIdentity(nationalIdentity));
	}

	private Result isIdentityNumberExist(String identityNumber) {
		if (candidateDao.existsByNationalIdentity(identityNumber)) {
			return new ErrorResult(Messages.nationalityIdentityExist);
		}
		return new SuccessResult();
	}

	private Result isMernisVerified(Candidate candidate) {
		MernisPerson mernisPerson = new MernisPerson(candidate.getFirstName(), candidate.getLastName(),
				candidate.getNationalIdentity(), candidate.getBirthDate());
		boolean result = this.checkRealPersonService.validate(mernisPerson);
		if (result) {
			return new SuccessResult();
		}
		return new ErrorResult(Messages.personInValid);
	}

	private Result checkIfEmailExists(String email) {
		if (this.userService.userExists(email)) {
			return new ErrorResult(Messages.emailExist);
		}
		return new SuccessResult();
	}
	
	private ActivationCodeCandidateDto createActivationCode(Candidate candidate) {
		ActivationCodeCandidateDto activationCodeCandidateDto=new ActivationCodeCandidateDto();
		activationCodeCandidateDto.setUserId(candidate.getId());
		activationCodeCandidateDto.setActivationCode(CodeGenerator.codeGenerator());
		return activationCodeCandidateDto;
	}

}
