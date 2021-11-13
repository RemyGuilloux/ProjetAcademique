package fr.formation.Gardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "num", nullable = false)
	private int num;
	@Column(name = "town", nullable = false)
	private String town;
	@Column(name = "zipcode", nullable = false)
	private int zipcode;

	public Address() {

	}

	public Address(Long id, String name, int num, String town, int zipcode) {

		this.id = id;
		this.name = name;
		this.num = num;
		this.town = town;
		this.zipcode = zipcode;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", num=" + num + ", town=" + town + ", zipcode=" + zipcode
				+ "]";
	}

}
