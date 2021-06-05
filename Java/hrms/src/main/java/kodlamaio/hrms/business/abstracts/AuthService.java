package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterCandidateDto;

public interface AuthService {
Result registerCandiate(RegisterCandidateDto registerCandidateDto);
Result registerEmployer(Employer employer);
Result login(String email,String password);
Result verifyCandidate(String activationCode,int userId);
Result verifyEmployer(String activationCode,int userId);

}
