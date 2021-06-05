package kodlamaio.hrms.core.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.abstracts.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email
	@NotBlank
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotBlank
	@NotNull
	@Column(name="password")
	private String password;

}
