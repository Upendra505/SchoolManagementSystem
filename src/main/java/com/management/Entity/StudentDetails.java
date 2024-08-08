package com.management.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "StudentDetails")
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private Integer studentId;

	@Column(name = "First_name")
	private String firstName;

	@Column(name = "Last_name")
	private String lastName;

	@Column(name = "Class")
	private String className;

	@Column(name = "phonenumber" )
	private Number phoneNumber;

	@ManyToOne
	@JoinColumn(name = "s_Id")
	private SchoolDetails schoolDetails;

	@OneToMany(mappedBy = "studentDetails")
	private Set<Grades> grades;

	@OneToMany(mappedBy = "studentDetails")
	private Set<Attendance> attendances;

	@Override
	public String toString() {
		return "StudentDetails [firstName=" + firstName + ", lastName=" + lastName
				+ ", className=" + className + ", phoneNumber=" + phoneNumber + "]";
	}

}


