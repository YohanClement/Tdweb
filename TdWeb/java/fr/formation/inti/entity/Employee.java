package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Employee {
	private Integer empId;
	private Date endDate;
	private String firstName;
	private String lastName;
	private Date startDate;
	private String title;
	private String fullName;
	
	

	public Employee() {
	}

	public Employee(String firstName, String lastName, Date startDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
	}

	public Employee(String firstName, String lastName, Date startDate2, String title) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate2;
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EMP_ID", unique = true, nullable = false)
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Transient // pour un attribut qui n'est pas dans la bdd
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", endDate=" + endDate + ", firstName=" + firstName + ", lastName="
				+ lastName + ", startDate=" + startDate + ", title=" + title + ", fullName=" + fullName + "]";
	}

}
