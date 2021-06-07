package kodlamaio.hrms.entities.dtos;



import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCandidateDto {
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	@Email
	private String email;
	private String password;
	private String rePassword;
}
