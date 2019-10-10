package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owner")

public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OWNER_ID")
	private int ownerID;
	@Column(name="OWNER_NAME")
	private String ownerName;
	
	public Owner() {
		super();
	}
	
	public Owner(int id, String ownerName) {
		super();
		this.ownerID = id;
		this.ownerName = ownerName;
	}
	
	public Owner(String ownerName) {
		super();
		this.ownerName = ownerName;
	}

	public int getId() {
		return ownerID;
	}

	public void setId(int id) {
		this.ownerID = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@Override
	public String toString() {
	    return "Owner [id=" + ownerID + ", ownerName=" + ownerName + "]";
	}
}