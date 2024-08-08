package com.management.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "SchoolDetails")
public class SchoolDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_Id")
	private Integer schoolId;

	@Column(name = "s_name")
	private String schoolName;

	@Column(name = "s_location")
	private String location;

	@Column(name = "s_timings")
	private String timings;

	@Column(name = "s_email")
	private String email;

	@OneToMany(mappedBy = "schoolDetails")
	private Set<StudentDetails> StudentDetails;

	@OneToMany(mappedBy = "schoolDetails")
	private Set<TeacherDetails> teachers;

	
	@Override
	public String toString() {
		return "SchoolDetails [schoolName=" + schoolName + ", location=" + location
				+ ", timings=" + timings + ", email=" + email +  "]";
	}


	
	

}
