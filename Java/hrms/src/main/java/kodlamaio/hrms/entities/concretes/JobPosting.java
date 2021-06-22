package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_postings")
@Entity
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(targetEntity = City.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "job_position_id", referencedColumnName = "id")
	private JobPosition jobPosition;
	
	@ManyToOne(targetEntity = City.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@Column(name = "description")
	private String description;



	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "open_position_number")
	private int openPositionNumber;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "closed_date")
	private LocalDate closedDate;

	@Column(name = "is_active")
	private boolean isActive = true;

	@ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	private Employer employer;

}
