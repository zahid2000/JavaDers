package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerActivationByEmployeeDto {

	private int employeeId;

	private int employerId;

	private boolean isConfirmed;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate confirmDate = LocalDate.now();
}
