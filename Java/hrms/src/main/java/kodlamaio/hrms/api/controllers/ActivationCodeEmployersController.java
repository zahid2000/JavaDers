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

import kodlamaio.hrms.business.abstracts.ActivationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.ActivationCodeEmployer;
import kodlamaio.hrms.entities.dtos.ActivationCodeEmployerDto;

@RestController
@RequestMapping("api/ActivationCodeEmployers/")
public class ActivationCodeEmployersController {

	private ActivationCodeEmployerService activationCodeEmployerService;

	@Autowired
	public ActivationCodeEmployersController(ActivationCodeEmployerService activationCodeEmployerService) {
		super();
		this.activationCodeEmployerService = activationCodeEmployerService;
	}

	@GetMapping("getAll")
	DataResult<List<ActivationCodeEmployer>> getAll(){
		return this.activationCodeEmployerService.getAll();
	}
	
	@PostMapping("add")
	Result add(@Valid @RequestBody ActivationCodeEmployerDto activationCodeEmployerDto) {
		return this.activationCodeEmployerService.add(activationCodeEmployerDto);
	}
	
	@GetMapping("getByEmployerId")
	DataResult<ActivationCodeEmployer> getByEmployerId(@RequestParam int id){
		return this.activationCodeEmployerService.getByEmployerId(id);
	}
}
