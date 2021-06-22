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

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("api/jobposting")
public class JobPostingsController {
	private JobPostingService jobPostingService;
	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	@PostMapping("add")
	public Result add(@RequestBody @Valid JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.add(jobPostingAddDto);
	}
	@PostMapping("delete")
	public Result delete(@RequestBody JobPosting  jobPosting) {
		return this.jobPostingService.delete(jobPosting);
	}
	@GetMapping("findByIsActive")
	public DataResult<List<JobPosting>> findByIsActive(){
		return this.jobPostingService.findByIsActive();
	}
	@GetMapping("findByIsActiveOrderByClosedDate") 
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate(){
		return this.jobPostingService.findByIsActiveOrderByClosedDate();
	}
	@GetMapping("findByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(@RequestParam String companyName){
		return this.jobPostingService.findByIsActiveAndEmployer_CompanyName(companyName);
	}
	
	@GetMapping("getAll")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}
}
