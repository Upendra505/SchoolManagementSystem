package com.management.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface TeacherDetailsServices {
	void selectTeacherDetails(Session session);

	void insertTeacherDetails(Session session, Scanner scanner);

	void updateTeacherDetails(Session session, Scanner scanner);

	void deleteTeacherDetails(Session session, Scanner scanner);
}
