package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCodeEmployer;
import kodlamaio.hrms.entities.dtos.ActivationCodeEmployerDto;

public interface ActivationCodeEmployerService {
DataResult<List<ActivationCodeEmployer>> getAll();
Result add(ActivationCodeEmployerDto activationCodeEmployerDto);
Result update(ActivationCodeEmployerDto activationCodeEmployerDto);
Result verify(String activationCode,int userId);
DataResult<ActivationCodeEmployer> getByEmployerId(int id);
}
