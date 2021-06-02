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

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("api/job-titles/")
public class JobTitlesController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("getAll")
	public DataResult<List<JobTitle>> getAll() {
		return jobTitleService.getAll();
	}

	@PostMapping("add")
	Result add( @RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}

	@GetMapping("getById")
	DataResult<JobTitle> getById(@RequestParam int id) {
		return this.jobTitleService.getById(id);
	}

	@GetMapping("getByTitle")
	DataResult<JobTitle> getByTitle(String title){
		return this.jobTitleService.getByTitle(title);
	}

}
