package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activation_code_employers")
@PrimaryKeyJoinColumn(name = "id")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class ActivationCodeEmployer extends ActivationCode {

	  @OneToOne()
	    @JoinColumn(name = "employer_id",referencedColumnName = "id")
	    private Candidate candidate;
}
