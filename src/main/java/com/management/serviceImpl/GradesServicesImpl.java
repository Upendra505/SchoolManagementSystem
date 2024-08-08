package com.management.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.management.Entity.Grades;
import com.management.Entity.SchoolDetails;
import com.management.service.GradesService;

public class GradesServicesImpl implements GradesService {
	Session session;
	Scanner scanner;

	@Override
	public void selectGradeDetails(Session session) {
		this.session = session;

		Query<Grades> query = session.createQuery("from Grades", Grades.class);
		List<Grades> list = query.list();
		for (Grades grades : list)
			System.out.println(grades);

	}

	@Override
	public void insertGradeDetails(Session session, Scanner scanner) {
		this.session = session;
		this.scanner = scanner;

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		try {
			Grades grades = new Grades();

			System.out.println("Enter StudentName:");
			grades.setStudentName(scanner.next());

			System.out.println("Enter the Grades");
			grades.setGrades(scanner.next());

			session.save(grades);
			System.out.println("Inserted Grades Sucessfully..");

		} catch (Exception e) {

			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println("Inserted failed Grades.");
		}
//	this.session.close();
	}

	@Override
	public void updateGradeDetails(Session session, Scanner scanner) {
		this.session = session;
		this.scanner = scanner;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		Grades grades = new Grades();

		System.out.println("Enter StudentId:");
		grades.setStudentId(scanner.nextInt());

		System.out.println("Enter Update Student Name:-");
		grades.setStudentName(scanner.next());

		System.out.println("Enter Update the Grades");
		grades.setGrades(scanner.next());

		session.update(grades);
		session.getTransaction().commit();
		System.out.print("Student Grades Update Sucessfully");
//		this.session.close();

	}

	@Override
	public void deleteGradeDetails(Session session, Scanner scanner) {
		this.session = session;
		this.scanner = scanner;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		Grades grades = new Grades();
		System.out.println("Enter StudentID:");
		grades.setStudentId(scanner.nextInt());

		session.delete(grades);

		System.out.println(" Record Deleted Sucessfully!");
		session.getTransaction().commit();
		this.session.close();

	}

}
