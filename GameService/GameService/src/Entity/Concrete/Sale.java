package Entity.Concrete;

import Entity.Abstract.Entity;

public class Sale implements Entity {
	private int id;

	public Sale(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
