package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
@RestController
@RequestMapping("api/users/")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	@GetMapping("getByEmail")
	public DataResult<User> getByEmail(String email) {
		return this.userService.getByEmail(email);
	}

}
