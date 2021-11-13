package fr.formation.Gardens.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "garden")
public class Garden {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "size", nullable = false)
	private double size;
	@Column(name = "localisation", nullable = false)
	private String localisation;
	@Column(name = "type_of_garden", nullable = false)
	private String typeOfGarden;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Address address;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Profil profil;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private CustomUser user;

	public Garden() {

	}

	public Garden(Long id, String name, double size, String localisation, String typeOfGarden, Address address,
			Profil profil, CustomUser user) {

		this.id = id;
		this.name = name;
		this.size = size;
		this.localisation = localisation;
		this.typeOfGarden = typeOfGarden;
		this.address = address;
		this.profil = profil;
		this.user = user;

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

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getTypeOfGarden() {
		return typeOfGarden;
	}

	public void setTypeOfGarden(String typeOfGarden) {
		this.typeOfGarden = typeOfGarden;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public CustomUser getUser() {
		return user;
	}

	public void setUser(CustomUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Garden [id=" + id + ", name=" + name + ", size=" + size + ", localisation=" + localisation
				+ ", typeOfGarden=" + typeOfGarden + ", address=" + address + ", profil=" + profil + ", user=" + user
				+ "]";
	}

}
