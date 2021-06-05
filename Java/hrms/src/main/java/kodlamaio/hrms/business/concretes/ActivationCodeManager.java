package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService {

	private ActivationCodeDao activationCodeDao;

	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public DataResult<List<ActivationCode>> getAll() {
	return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll());
	}

	@Override
	public Result add(ActivationCode activationCode) {
		this.activationCodeDao.save(activationCode);
		return new SuccessResult();
	}

	@Override
	public DataResult<ActivationCode> findById(int id) {
		return new SuccessDataResult<ActivationCode>(this.activationCodeDao.findById(id));
	}

}
