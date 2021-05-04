package Entity.Concrete;

import java.util.Date;

import Entity.Abstract.Entity;

public class Gamer implements Entity {
	private int id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private long nationalIdentity;

	public Gamer(int id, String firstName, String lastName, Date dateOfBirth, long nationalIdentity) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalIdentity = nationalIdentity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(long nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}
}
