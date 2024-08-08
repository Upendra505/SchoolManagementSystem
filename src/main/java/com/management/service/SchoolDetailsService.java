package com.management.service;

import java.util.Scanner;

import org.hibernate.Session;

public interface SchoolDetailsService
{
	void selectSchoolDetails(Session session);
	void insertSchoolDetails(Session session, Scanner scanner);
	void updateSchoolDetails(Session session, Scanner scanner);
	void deleteSchoolDetails(Session session, Scanner scanner);


}
