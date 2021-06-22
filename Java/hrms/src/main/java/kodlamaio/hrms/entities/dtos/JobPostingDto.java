package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobPostingDto {
	
	private int id;
	private String employerCompanyName;
	private String jobPositionPosition;
	private String cityCity;
	private int openPositionNumber;
	private LocalDate createdDate;
	private LocalDate closedDate;
	private String description;
	
	
}