package com.management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Grades")
public class Grades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "studentId", nullable = false)
	private Integer studentId;

	@Column(name = "Student_Name")
	private String studentName;

	@Column(name = "Grades", nullable = true)
	private String grades;

	@ManyToOne
	@JoinColumn(name = "StudentId", insertable = false, updatable = false)
	private StudentDetails studentDetails;

	
	@Override
	public String toString() {
		return "Grades [ studentName=" + studentName + ", grades=" + grades
				+ "]";
	}

	
}
