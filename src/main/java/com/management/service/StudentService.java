package com.management.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface StudentService {
	void selectStudentDetails(Session session);

	void insertStudentDetails(Session session, Scanner scanner);

	void updateStudentDetails(Session session, Scanner scanner);

	void deleteStudentDetails(Session session, Scanner scanner);

}
