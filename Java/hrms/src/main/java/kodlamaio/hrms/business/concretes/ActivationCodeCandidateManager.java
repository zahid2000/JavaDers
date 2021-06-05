package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
		ActivationCodeCandidate activationCodeCandidate = new ActivationCodeCandidate();
		activationCodeCandidate = this.activationCodeCandidateDao
				.findByCandidate_Id(activationCodeCandidateDto.getUserId());
		activationCodeCandidate.setActivationCode(activationCodeCandidateDto.getActivationCode());
		this.activationCodeCandidateDao.save(activationCodeCandidate);
		return new SuccessResult("Updated");

	}

	@Override
	public DataResult<ActivationCodeCandidate> getById(int id) {
		return new SuccessDataResult<ActivationCodeCandidate>(this.activationCodeCandidateDao.findByCandidate_Id(id));
	}

}
