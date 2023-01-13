package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	private Integer iduser;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String rolename;
	private Date creationDate;
	private String droit;
	
	public User() {
	}

	public User(String Email, String Password) {
		this.email = Email;
		this.password = Password;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IDuser", unique = true, nullable = false)
	public Integer getIduser() {
		return iduser;
	}
	
	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	@Column(name = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "Firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "Lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Column(name = "RoleName")
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Column(name = "CreationDate")
	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Column(name = "droit")
	public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}

	@Override
	public String toString() {
		return "User [Iduser=" + iduser + ", Email=" + email + ", Password=" + password + ", Firstname=" + firstname
				+ ", Lastname=" + lastname + ", Rolename=" + rolename + ", CreationDate=" + creationDate + "]";
	}
	
	
}
