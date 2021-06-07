package kodlamaio.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("api/job-titles/")
public class JobPositionController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("getAll")
	public DataResult<List<JobPosition>> getAll() {
		return jobPositionService.getAll();
	}

	@PostMapping("add")
	Result add( @RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}

	@GetMapping("getById")
	DataResult<JobPosition> getById(@RequestParam int id) {
		return this.jobPositionService.getById(id);
	}

	@GetMapping("getByTitle")
	DataResult<JobPosition> getByTitle(String position){
		return this.jobPositionService.getByPosition(position);
	}

}
