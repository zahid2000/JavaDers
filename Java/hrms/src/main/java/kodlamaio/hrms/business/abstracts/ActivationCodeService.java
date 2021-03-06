package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	DataResult<List<ActivationCode>> getAll();
	Result add(ActivationCode activationCode);
	
	DataResult<ActivationCode> findById(int id);
}
