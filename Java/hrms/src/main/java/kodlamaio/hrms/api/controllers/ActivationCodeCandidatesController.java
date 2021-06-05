package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCodeCandidate;
import kodlamaio.hrms.entities.dtos.ActivationCodeCandidateDto;

@RestController
@RequestMapping("api/activation-code-candidates/")
public class ActivationCodeCandidatesController {

	private ActivationCodeCandidateService activationCodeCandidateService;

	@Autowired
	public ActivationCodeCandidatesController(ActivationCodeCandidateService activationCodeCandidateService) {
		super();
		this.activationCodeCandidateService = activationCodeCandidateService;
	}

	@GetMapping("getAll")

	public DataResult<List<ActivationCodeCandidate>> getAll() {
		return this.activationCodeCandidateService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody ActivationCodeCandidateDto activationCodeCandidateDto) {
		return this.activationCodeCandidateService.add(activationCodeCandidateDto);
	}

	@PostMapping("update")
	public Result update(@RequestBody ActivationCodeCandidateDto activationCodeCandidateDto) {
		return this.activationCodeCandidateService.update(activationCodeCandidateDto);
	}

	@GetMapping("getById")

	DataResult<ActivationCodeCandidate> getById( @RequestParam int id){
		return this.activationCodeCandidateService.getById(id);
	}

}
