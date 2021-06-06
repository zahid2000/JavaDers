package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCodeCandidate;
import kodlamaio.hrms.entities.dtos.ActivationCodeCandidateDto;

public interface ActivationCodeCandidateService {

	DataResult<List<ActivationCodeCandidate>> getAll();
	Result add(ActivationCodeCandidateDto activationCodeCandidatDtoe);
	Result update(ActivationCodeCandidateDto activationCodeCandidateDto);
	DataResult<ActivationCodeCandidateDto> getByCandidateId(int id);
	DataResult<ActivationCodeCandidate> findById(int id);
	Result verify(String activationCode,int userId);
}
