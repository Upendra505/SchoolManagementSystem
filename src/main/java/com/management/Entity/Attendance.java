package com.management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.query.Query;

import com.mysql.cj.Session;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = true)
	private Integer studentId;

	@Column(name = "attendance_date")
	private String attendanceDate;

	@Column(name = "attendance_Month",nullable = true)
	private String attendance_Month;

	@Column(name = "attendance_Year")
	private String attendance_Year;

	@Column(name = "attendance_status")
	private String attendanceStatus;
	@ManyToOne
	@JoinColumn(name = "studentId", insertable = false, updatable = false)
	private StudentDetails studentDetails;

	@Override
	public String toString() {
		return "Attendance [studentId=" + studentId + ", attendanceDate=" + attendanceDate + ", attendance_Month="
				+ attendance_Month + ", attendance_Year=" + attendance_Year + ", attendanceStatus=" + attendanceStatus
				+ "]";
	}

}
