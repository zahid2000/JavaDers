package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidates/")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("getAll")
	DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}

	@PostMapping("add")
	Result add( @RequestBody Candidate candidate) {
		return this.candidateService.add( candidate );
	}

	@GetMapping("getById")
	DataResult<Candidate> getById(@RequestParam int id){
		return this.candidateService.getById(id);
	}

	@GetMapping("getByEmail")
	DataResult<List<Candidate>> getByEmail(@RequestParam String email){
		return this.candidateService.getByEmail(email);
	}

	@GetMapping("getByNationalIdentity")
	DataResult<Candidate> getByNationalIdentity(@RequestParam String nationalIdentity){
		return this.candidateService.getByNationalIdentity(nationalIdentity);
	}

}
