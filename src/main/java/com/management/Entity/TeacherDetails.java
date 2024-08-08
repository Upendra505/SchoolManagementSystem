package com.management.Entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teacherDetails")
public class TeacherDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TeacherId")
	private Integer teacherId;

	@Column(name = "First_name")
	private String firstName;

	@Column(name = "Last_name")
	private String lastName;

	@Column(name = "phonenumber")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "SchoolId")
	private SchoolDetails schoolDetails;

	
	@Override
	public String toString() {
		return "TeacherDetails [ firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	

}
