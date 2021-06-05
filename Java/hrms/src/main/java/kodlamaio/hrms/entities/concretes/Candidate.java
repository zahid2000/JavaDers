package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.entities.abstracts.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User implements Person {
	
	@JsonIgnore()
	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@JsonIgnore()
	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@JsonIgnore()
	@Column(name = "national_identity")
	@NotBlank
	@NotNull
	private String nationalIdentity;
	
	@JsonIgnore()
	@Column(name = "birth_date")
	@NotNull
	private LocalDate birthDate;
	
	

}
