package com.management.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface GradesService {
	void selectGradeDetails(Session session);

	void insertGradeDetails(Session session, Scanner scanner);

	void updateGradeDetails(Session session, Scanner scanner);

	void deleteGradeDetails(Session session, Scanner scanner);

}
