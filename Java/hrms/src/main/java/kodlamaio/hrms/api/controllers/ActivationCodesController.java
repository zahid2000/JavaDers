package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@RestController
@RequestMapping("api/activation-codes/")
public class ActivationCodesController {

	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	};

	@GetMapping("getAll")
	public DataResult<List<ActivationCode>> getAll() {
		return this.activationCodeService.getAll();
	}

	@PostMapping("add")
	public Result add(ActivationCode activationCode) {
		return this.activationCodeService.add(activationCode);
	}

	@GetMapping("findById")
	public DataResult<ActivationCode> findById(int id){
		return this.activationCodeService.findById(id);
	}

}
