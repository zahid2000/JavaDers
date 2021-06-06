package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeCandidateDao;
import kodlamaio.hrms.entities.concretes.ActivationCodeCandidate;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.ActivationCodeCandidateDto;

@Service
public class ActivationCodeCandidateManager implements ActivationCodeCandidateService {

	private ActivationCodeCandidateDao activationCodeCandidateDao;

	@Autowired
	public ActivationCodeCandidateManager(ActivationCodeCandidateDao activationCodeCandidateDao) {
		super();
		this.activationCodeCandidateDao = activationCodeCandidateDao;
	}

	@Override
	public DataResult<List<ActivationCodeCandidate>> getAll() {
		return new SuccessDataResult<List<ActivationCodeCandidate>>(this.activationCodeCandidateDao.findAll());
	}

	@Override
	public Result add(ActivationCodeCandidateDto activationCodeCandidateDto) {
		ActivationCodeCandidate activationCodeCandidate = new ActivationCodeCandidate();
		activationCodeCandidate.setActivationCode(activationCodeCandidateDto.getActivationCode());
		Candidate candidate = new Candidate();
		candidate.setId(activationCodeCandidateDto.getUserId());
		activationCodeCandidate.setCandidate(candidate);
		this.activationCodeCandidateDao.save(activationCodeCandidate);
		return new SuccessResult("Added");
	}

	@Override
	public Result update(ActivationCodeCandidateDto activationCodeCandidateDto) {
		ActivationCodeCandidate activationCodeCandidate = this.activationCodeCandidateDao
				.findByCandidate_Id(activationCodeCandidateDto.getUserId());
		activationCodeCandidate.setActivationCode(activationCodeCandidateDto.getActivationCode());
		this.activationCodeCandidateDao.save(activationCodeCandidate);
		return new SuccessResult("Updated");

	}

	@Override
	public DataResult<ActivationCodeCandidateDto> getByCandidateId(int id) {
		ActivationCodeCandidateDto activationCodeCandidateDto = new ActivationCodeCandidateDto();
		activationCodeCandidateDto
				.setActivationCode(this.activationCodeCandidateDao.findByCandidate_Id(id).getActivationCode());
		activationCodeCandidateDto.setUserId(this.activationCodeCandidateDao.findByCandidate_Id(id).getId());
		return new SuccessDataResult<ActivationCodeCandidateDto>(activationCodeCandidateDto);
	}

	@Override
	public DataResult<ActivationCodeCandidate> findById(int id) {
		return new SuccessDataResult<ActivationCodeCandidate>(this.activationCodeCandidateDao.findById(id));
	}

	@Override
	public Result verify(String activationCode, int userId) {
		ActivationCodeCandidate activationCodeCandidate = this.activationCodeCandidateDao.findByCandidate_Id(userId);
		if (activationCodeCandidate.getActivationCode().equals(activationCodeCandidate)) {
			activationCodeCandidate.setConfirmed(true);
			this.activationCodeCandidateDao.save(activationCodeCandidate);
			return new SuccessResult("Verified");
		}
		return new ErrorResult("could not be verified");
	}

}
