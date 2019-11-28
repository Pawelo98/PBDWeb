package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Bulidings")
public class Building {

	public enum Type { Stadium, Pitch };

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Surface")
	private float surface;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Type")
	@Enumerated(EnumType.STRING)
	private Type type;

	
	
//	@Column(name="club")
//	private int club;
	
	public Building() {
		
	}
	
	public Building(int id, float surface, String name, String address, String type) {
		
		this.id = id;
		this.surface = surface;
		this.name = name;
		this.address = address;
		this.type = Type.valueOf(type);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
//	public int getClub() {
//	return club;
//}
//
//public void setClub(int club) {
//	this.club = club;
//}

	@Override
	public String toString() {
		return "Building [id=" + id + ", surface=" + surface + ", name=" + name + ", address=" + address + ", type="
				+ type +
				//", club=" + club +
				"]";
	}
	

	
	
}


