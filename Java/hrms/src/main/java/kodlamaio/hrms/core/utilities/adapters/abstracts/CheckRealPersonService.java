package kodlamaio.hrms.core.utilities.adapters.abstracts;

import kodlamaio.hrms.core.utilities.adapters.models.MernisPerson;

public interface CheckRealPersonService {
	boolean validate(MernisPerson mernisPerson);
}
