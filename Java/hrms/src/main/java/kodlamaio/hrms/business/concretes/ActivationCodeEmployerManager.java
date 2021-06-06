package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeEmployerDao;
import kodlamaio.hrms.entities.concretes.ActivationCodeEmployer;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.ActivationCodeEmployerDto;

@Service
public class ActivationCodeEmployerManager implements ActivationCodeEmployerService {

	private ActivationCodeEmployerDao activationCodeEmployerDao;

	@Autowired
	public ActivationCodeEmployerManager(ActivationCodeEmployerDao activationCodeEmployerDao) {
		super();
		this.activationCodeEmployerDao = activationCodeEmployerDao;
	}

	@Override
	public DataResult<List<ActivationCodeEmployer>> getAll() {
		return new SuccessDataResult<List<ActivationCodeEmployer>>(this.activationCodeEmployerDao.findAll());
	}

	@Override
	public Result add(ActivationCodeEmployerDto activationCodeEmployerDto) {
		ActivationCodeEmployer activationCodeEmployer=new ActivationCodeEmployer();
		activationCodeEmployer.setActivationCode(activationCodeEmployerDto.getActivationCode());
		Employer employer=new Employer();
		employer.setId(activationCodeEmployerDto.getUserId());
		activationCodeEmployer.setEmployer(employer);
		this.activationCodeEmployerDao.save(activationCodeEmployer);
		return new  SuccessResult("Added");
	}

	@Override
	public DataResult<ActivationCodeEmployer> getByEmployerId(int id) {
		return new SuccessDataResult<ActivationCodeEmployer>(this.activationCodeEmployerDao.findByEmployer_Id(id));
	}

	@Override
	public Result update(ActivationCodeEmployerDto activationCodeEmployerDto) {
		ActivationCodeEmployer activationCodeEmployer=this.activationCodeEmployerDao.findByEmployer_Id(activationCodeEmployerDto.getUserId());
		activationCodeEmployer.setActivationCode(activationCodeEmployerDto.getActivationCode());
		this.activationCodeEmployerDao.save(activationCodeEmployer);
		return new SuccessResult("Updated");
	}

	@Override
	public 	Result verify(String activationCode,int userId) {
		ActivationCodeEmployer activationCodeEmployer=this.activationCodeEmployerDao.findByEmployer_Id(userId);
		if(activationCodeEmployer.getActivationCode().equals(activationCodeEmployer.getActivationCode())) {
		activationCodeEmployer.setConfirmed(true);
		this.activationCodeEmployerDao.save(activationCodeEmployer);
		return new SuccessResult("Verified");
	}
		return new ErrorResult("could not be verified");
	}
}
