package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingAddDto {

	
	@JsonIgnore
	private int id;
	private int employerId;

	private int openPositionNumber;
	private int minSalary;
	private int maxSalary;
	private int cityId;
	private int jobPositionId;
	private LocalDate closedDate;
	private String description;
	
}
