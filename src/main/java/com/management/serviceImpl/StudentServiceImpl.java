package com.management.serviceImpl;
	
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.management.Entity.Grades;
import com.management.Entity.SchoolDetails;
import com.management.Entity.StudentDetails;
import com.management.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private Scanner scanner;
	private Session session;

	@Override
	public void selectStudentDetails(Session session)
	{
		this.session = session;

		Query<StudentDetails> query = session.createQuery("from StudentDetails", StudentDetails.class);
		List<StudentDetails> list = query.list();

		for (StudentDetails std : list)

			System.out.println(std);
	}

	@Override
	

	public void insertStudentDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;
		  if (!session.getTransaction().isActive()) {
		        session.beginTransaction();
		    }

		try {
		System.out.println("Enter The StudentDetails:FirstName , LastName , Class, MobileNumber");
		
		StudentDetails std = new StudentDetails();
		
		System.out.println("Enter The Student FirstName:");
		std.setFirstName(scanner.next());
		System.out.println("Enter The Student LastName:");
		std.setLastName(scanner.next());
		System.out.println("Studing Which Class:");
		std.setClassName(scanner.next());
		System.out.println("Enter MobileNumber");
		std.setPhoneNumber(scanner.nextLong());

	
		SchoolDetails schoolDetails = new SchoolDetails();
		schoolDetails.setSchoolId(1);
		std.setSchoolDetails(schoolDetails);

		session.save(std);
		System.out.println("Student Record Insert Sucessfully!");
	} 
		catch (Exception e)
		{
        if (session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
        e.printStackTrace();
        System.out.println("Failed to insert student record.");
    }
//		this.session.close();

	}

	@Override
	public void updateStudentDetails(Session session, Scanner scanner) {
		this.scanner = scanner;
		this.session = session;
		
		if (!session.getTransaction().isActive()) {
	        session.beginTransaction();
	    }
		
		try {

		StudentDetails updatestd = new StudentDetails();
		System.out.println(" Update StudentDetails:FirstName , LastName , Class, MobileNumber");
        
		System.out.println("Enter StudentID:-");
		updatestd.setStudentId(scanner.nextInt());
		
		System.out.println("Enter The Update new Student FirstName:");
		updatestd.setFirstName(scanner.next());
		System.out.println("Enter The Student Update new LastName:");
		updatestd.setLastName(scanner.next());
		System.out.println("update new Class:");
		updatestd.setClassName(scanner.next());
		System.out.println("Enter update MobileNumber");
		updatestd.setPhoneNumber(scanner.nextLong());
		
		SchoolDetails schoolDetails = new SchoolDetails();
		schoolDetails.setSchoolId(1);
		updatestd.setSchoolDetails(schoolDetails);
		
		session.saveOrUpdate(updatestd);
		System.out.println("Sucessfuly Updated Student Details");
		session.getTransaction().commit();
		}
		catch (Exception e) {
	        
	        if (session.getTransaction().isActive()) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        System.out.println("Failed to insert student record.");
	    }
//		this.session.close();

	}

	@Override
	public void deleteStudentDetails(Session session, Scanner scanner) {
		this.session = session;
		this.scanner = scanner;
		if (!session.getTransaction().isActive()) {
	        session.beginTransaction();
	    }
		StudentDetails dsts = new StudentDetails();
		System.out.println("Enter StudenId:");
		dsts.setStudentId(scanner.nextInt());
		
	
		session.delete(dsts);

		System.out.println(" Record Deleted Sucessfully!");
		session.getTransaction().commit();
		this.session.close();

	}

}
