package com.management.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.management.Entity.Attendance;
import com.management.Entity.Grades;
import com.management.service.AttendanceService;

public class AttendanceImpl implements AttendanceService {

	private static final String StudentId = null;
	Session session;
	Scanner scanner;

	@Override
	public void selectAttendanceDetails(Session session) {
		this.session = session;

		Query<Attendance> query = session.createQuery("from Attendance ", Attendance.class);
		List<Attendance> list = query.list();

		for (Attendance attendance : list)

			System.out.println(attendance);

	}

	@Override
	public void insertAttendanceDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		try {
			Attendance attendance = new Attendance();

			System.out.println("Student Id:");
			attendance.setStudentId(scanner.nextInt());

			System.out.println("Enter The Date:");
			attendance.setAttendanceDate(scanner.next());

			System.out.println("Enter The Month:");
			attendance.setAttendance_Month(scanner.next());

			System.out.println("Enter The Year:");
			attendance.setAttendance_Year(scanner.next());

			System.out.println("Attendence Status: Present/Absent:-");
			attendance.setAttendanceStatus(scanner.next());

			session.save(attendance);
			System.out.println("Attendance Record  Sucessfully!");
		} catch (Exception e) {

			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println("Student Attendence Not record.");
		}

//	this.session.close();
	}

	@Override
	public void updateAttendanceDetails(Session session, Scanner scanner)
	{
		this.scanner = scanner;
		this.session = session;

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		Attendance attendance = new Attendance();

		System.out.println("Enter Student ID:-");
		attendance.setStudentId(scanner.nextInt());

		System.out.println("Enter Update attendance date:-");
		attendance.setAttendanceDate(scanner.next());

		System.out.println("Enter Update attendance Month:-");
		attendance.setAttendanceDate(scanner.next());

		System.out.println("Enter Update attendance year:-");
		attendance.setAttendanceDate(scanner.next());

		System.out.println("Attendence Status:- Present/Absent:");
		attendance.setAttendanceStatus(scanner.next());

		session.saveOrUpdate(attendance);
		session.getTransaction().commit();
//		this.session.close();

	}

	@Override
	public void deleteAttendanceDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;

		this.session = session;
		this.scanner = scanner;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		Attendance attendance = new Attendance();
		System.out.println("Enter StudentID:");
		attendance.setStudentId(scanner.nextInt());

		session.delete(attendance);

		System.out.println(" Record Deleted Sucessfully!");
		session.getTransaction().commit();
		this.session.close();

	}

}
