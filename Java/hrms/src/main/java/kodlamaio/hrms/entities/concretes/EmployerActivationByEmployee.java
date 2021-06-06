package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers_activation_by_employees")
public class EmployerActivationByEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne()
	@JoinColumn(name="employee_id",referencedColumnName = "id")
	private Employee employee;
	
	@OneToOne()
	@JoinColumn(name="employer_id",referencedColumnName = "id")
	private Employer employer;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirm_date")
	private LocalDate confirmDate=LocalDate.now();
}
