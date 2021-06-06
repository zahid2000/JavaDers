package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;

@RestController
@RequestMapping("api/auth/")
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("registerCandidate")
	public Result registerCandiate(@Valid @RequestBody RegisterCandidateDto registerCandidateDto) {
		return this.authService.registerCandiate(registerCandidateDto);
	}
	@PostMapping("registerEmployer")
	public	Result registerEmployer(@Valid @RequestBody RegisterForEmployerDto registerForEmployerDto) {
		return this.authService.registerEmployer(registerForEmployerDto);
	}
	@PostMapping("login")
	public	Result login(@Valid @RequestParam String email, String password) {
		return this.authService.login(email, password);
	}
	@PostMapping("verifyCandidate")
	public	Result verifyCandidate(@Valid @RequestBody String activationCode, int userId) {
		return this.authService.verifyCandidate(activationCode, userId);
	}
	@PostMapping("verifyEmployer")
	public	Result verifyEmployer(@Valid @RequestBody String activationCode, int userId) {
		return this.authService.verifyEmployer(activationCode, userId);
	}
}
