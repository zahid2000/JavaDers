package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activation_codes")

@Inheritance(strategy = InheritanceType.JOINED)
public class ActivationCode {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore()
	private int id;

	@JsonIgnore()
	@Column(name = "activation_code")
	private String activationCode;

	@JsonIgnore()
	@Column(name = "is_confirmed")
	private boolean isConfirmed = false;

	@JsonIgnore()
	@Column(name = "confirm_date")
	private LocalDate confirmDate = LocalDate.now();

}
