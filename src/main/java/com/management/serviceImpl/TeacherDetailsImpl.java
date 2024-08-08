package com.management.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.management.Entity.SchoolDetails;
import com.management.Entity.TeacherDetails;
import com.management.service.TeacherDetailsServices;

public class TeacherDetailsImpl implements TeacherDetailsServices {

	private Session session;
	private Scanner scanner;

	@Override
	public void selectTeacherDetails(Session session) {

		this.session = session;

		Query<TeacherDetails> query = session.createQuery("from TeacherDetails");
		List<TeacherDetails> list = query.list();

		for (TeacherDetails teacher : list)

			System.out.println(teacher);

	}

	@Override
	public void insertTeacherDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;

		try {
			if (!session.getTransaction().isActive()) {
				session.beginTransaction();
			}
			TeacherDetails teacher = new TeacherDetails();
			
			System.out.println(" Enter  First Name:");
			teacher.setFirstName(scanner.next());
			System.out.println("Enter  Last Name:");
			teacher.setLastName(scanner.next());
			System.out.println(" Phone Number:");
			teacher.setPhoneNumber(scanner.next());
			System.out.println("Enter Address:");
			teacher.setAddress(scanner.next());

			session.save(teacher);
			System.out.println(" Record Insert Sucessfully!");

			session.getTransaction().commit();

		} catch (Exception e) {

			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println("Failed to insert student record.");
		}
//		session.close();
	}

	@Override
	public void updateTeacherDetails(Session session, Scanner scanner) {

		this.scanner = scanner;
		this.session = session;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		TeacherDetails teacher = new TeacherDetails();
		System.out.println("Enter Teacher Id:");
		teacher.setTeacherId(scanner.nextInt());
		
		System.out.println(" Enter Update First Name:");
		teacher.setFirstName(scanner.next());
		System.out.println("Enter Update Last Name:");
		teacher.setLastName(scanner.next());
		System.out.println("Update Phone Number:");
		teacher.setPhoneNumber(scanner.next());
		System.out.println("Update Enter Address:");
		teacher.setAddress(scanner.next());

//		
		session.update(teacher);
		session.getTransaction().commit();
		System.out.println();
//		this.session.close();

	}

	@Override
	public void deleteTeacherDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		TeacherDetails teacher = new TeacherDetails();
		System.out.println(" Enter TeacherId:");
		teacher.setTeacherId(scanner.nextInt());

		session.delete(teacher);

		session.getTransaction().commit();
		System.out.println(" Record Deleted Sucessfully!");

		this.session.close();

	}

}
