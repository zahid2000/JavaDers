package Entity.Concrete;

import java.util.Date;

import Entity.Abstract.Entity;

public class Campany implements Entity {
	private int id;
	private String name;
	private Date startDate;
	private Date finishDate;

	public Campany(int id, String name, Date startDate, Date finishDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
}
