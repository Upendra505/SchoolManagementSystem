package com.management.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface AttendanceService
{
	void selectAttendanceDetails(Session session);

	void insertAttendanceDetails(Session session, Scanner scanner);

	void updateAttendanceDetails(Session session, Scanner scanner);

	void deleteAttendanceDetails(Session session, Scanner scanner);

}
