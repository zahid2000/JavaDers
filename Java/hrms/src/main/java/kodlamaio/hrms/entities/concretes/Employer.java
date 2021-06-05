package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;

import kodlamaio.hrms.core.entity.concretes.User;
import kodlamaio.hrms.entities.abstracts.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Employer extends User implements Person {

	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;

	@Column(name = "web_address")
	@NotBlank
	@NotNull
	private String webAddress;

	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;

	@Column(name = "is_activated")
	private boolean isActivated ;

}
