package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForEmployerDto {
	private String companyName;
	private String webAddress;
	private String phoneNumber;
	@Email
	private String email;
	private String password;
	private String rePassword;
}
