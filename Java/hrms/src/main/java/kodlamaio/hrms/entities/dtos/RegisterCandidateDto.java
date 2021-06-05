package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCandidateDto {
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private LocalDate birthDate;
	@Email
	private String email;
	private String password;
	private String rePassword;
}
