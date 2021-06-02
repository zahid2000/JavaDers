package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface UserService {
DataResult<List<User>> getAll();
}
