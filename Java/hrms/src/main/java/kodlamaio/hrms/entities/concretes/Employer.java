package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	//@Pattern(regexp = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$", message = "Telefon formatı hatalı...")
	@Size(min = 11, max = 11, message = "Telefon numarası 11 haneli olmalı")
	private String phoneNumber;

	@Column(name = "is_activated")
	private boolean isActivated =false;

}
