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
@Table(name = "profil")
public class Profil {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "localisation", nullable = false)
	private String localisation;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "lastname", nullable = false)
	private String lastname;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "mail", nullable = false)
	private String mail;
	@Column(name = "gender", nullable = false)
	private String gender;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private CustomUser user;

	public Profil(Long id, String localisation, String name, String lastname, String phone, String mail, String gender,
			Garden garden, CustomUser user) {

		this.id = id;
		this.localisation = localisation;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.mail = mail;
		this.gender = gender;
		this.user = user;

	}

	public Profil() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CustomUser getUser() {
		return user;
	}

	public void setUser(CustomUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Profil [id=" + id + ", localisation=" + localisation + ", name=" + name + ", lastname=" + lastname
				+ ", phone=" + phone + ", mail=" + mail + ", gender=" + gender + ", user=" + user + "]";
	}

}
