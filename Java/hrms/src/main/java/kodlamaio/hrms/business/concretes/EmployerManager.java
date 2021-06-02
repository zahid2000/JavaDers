package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.messages.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return  new  SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Messages.employersListed);
	}

	@Override
	public Result add(Employer employer) {
	if(this.employerDao.existsByEmail(employer.getEmail())) {
		return new ErrorResult(Messages.emailExists);
	}
		this.employerDao.save(employer);
		return new SuccessResult(Messages.employerAdded);
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return  new SuccessDataResult<Employer>(this.employerDao.findById(id),Messages.employersListed);
	}

	@Override
	public DataResult<List<Employer>> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Employer>> findByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
