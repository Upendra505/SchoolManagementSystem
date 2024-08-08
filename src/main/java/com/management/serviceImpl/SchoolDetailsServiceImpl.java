package com.management.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.management.Entity.SchoolDetails;
import com.management.service.SchoolDetailsService;

public class SchoolDetailsServiceImpl implements SchoolDetailsService {

	private Scanner scanner;
	private Session session;

	@Override
	public void selectSchoolDetails(Session session) {
		this.session = session;

		Query<SchoolDetails> query = session.createQuery("from SchoolDetails", SchoolDetails.class);
		List<SchoolDetails> list = query.list();

		for (SchoolDetails sdetails : list)

			System.out.println(sdetails);
	}

	@Override
	public void insertSchoolDetails(Session session, Scanner scanner) {

		this.scanner = scanner;
		this.session = session;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		try {
			SchoolDetails sdetails = new SchoolDetails();

			sdetails.setSchoolId(1);
			System.out.println("Enter School Name:");
			sdetails.setSchoolName(scanner.next());

			System.out.println("Enter School Location:");
			sdetails.setLocation(scanner.next());

			System.out.println("Enter E-mail");
			sdetails.setEmail(scanner.next());

			System.out.println("Enter SchoolTimings");
			sdetails.setTimings(scanner.next());

			session.save(sdetails);
			System.out.println("Inserted Records Sucessfully!");

		}

		catch (Exception e) {

			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println("Inserted failed School record.");
		}
//	this.session.close();
	}

	@Override
	public void updateSchoolDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;
		this.scanner = scanner;
		this.session = session;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		try {

			SchoolDetails sdetails = new SchoolDetails();

			sdetails.setSchoolId(1);
			System.out.println("Enter School Id:");
			sdetails.setSchoolId(scanner.nextInt());
			
			System.out.println("Enter Update School Name:");
			sdetails.setSchoolName(scanner.next());

			System.out.println("Enter Update School Location:");
			sdetails.setLocation(scanner.next());

			System.out.println("Enter Update E-mail");
			sdetails.setEmail(scanner.next());

			System.out.println("Enter Update SchoolTimings");
			sdetails.setTimings(scanner.next());

//			session.save(sdetails);
			

			session.saveOrUpdate(sdetails);
			System.out.println("Update  Records Sucessfully!");
			session.getTransaction().commit();
		} catch (Exception e) {

			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println("Inserted failed School record.");
		}
//	this.session.close();

	}

	@Override
	public void deleteSchoolDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		SchoolDetails sdetails = new SchoolDetails();

		System.out.println("Enter SchoolId:");
		sdetails.setSchoolId(scanner.nextInt());

		session.delete(sdetails);
		System.out.println(" Record Deleted Sucessfully!");
		session.getTransaction().commit();
		this.session.close();

	}
}