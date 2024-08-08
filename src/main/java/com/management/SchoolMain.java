package com.management;

import java.util.Scanner;
import  java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.management.serviceImpl.AttendanceImpl;
import com.management.serviceImpl.GradesServicesImpl;
import com.management.serviceImpl.SchoolDetailsServiceImpl;
import com.management.serviceImpl.StudentServiceImpl;
import com.management.serviceImpl.TeacherDetailsImpl;

public class SchoolMain {

    private static final int USERNAME = 1234;
    private static final int PASSWORD = 1234;

    public static void main(String[] args) {
        SessionFactory sFactory = ConfiguarationUtility.getSessionFactory();
        Session session = sFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            System.out.println("********School Management System Login Page********");

            Scanner sc = new Scanner(System.in);
            System.out.println("School UserID:-");
            int un = sc.nextInt();
            System.out.println("School Password:-");
            int pws = sc.nextInt();

            if (un == USERNAME && pws == PASSWORD) {
                System.out.println("Login Successfully");

                SchoolDetailsServiceImpl schoolService = new SchoolDetailsServiceImpl();
                StudentServiceImpl  studentService = new StudentServiceImpl();
                TeacherDetailsImpl  teacherService = new TeacherDetailsImpl();
                GradesServicesImpl  gradesService = new GradesServicesImpl();
                AttendanceImpl  attendanceService = new AttendanceImpl();

                Scanner scanner = new Scanner(System.in);
                int option;

                while (true) {
                    System.out.println("1. School Details");
                    System.out.println("2. Student Details");
                    System.out.println("3. Teacher Details");
                    System.out.println("4. Student Grades");
                    System.out.println("5. Attendance");
                    System.out.println("6. Close Application");
                    System.out.print("Select Option: ");

                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            SchoolDetails(session, schoolService, scanner);
                            break;
                        case 2:
                            StudentDetails(session, studentService, scanner);
                            break;
                        case 3:
                            TeacherDetails(session, teacherService, scanner);
                            break;
                        case 4:
                            StudentGrades(session, gradesService, scanner);
                            break;
                        case 5:
                            StudentAttendance(session, attendanceService, scanner);
                            break;
                        case 6:
                            System.out.println("Successfully Exited Application");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid Option. Try Again.");
                            break;
                    }
                }
            } else {
                System.out.println("Incorrect UserID or Password.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
            sFactory.close();
        }
    }

    private static void SchoolDetails(Session session, SchoolDetailsServiceImpl schoolService, Scanner scanner) {
        System.out.println("***********WELCOME TO SCHOOL DETAILS PAGE***********");
        System.out.println("1. Select School Details");
        System.out.println("2. Insert School Details");
        System.out.println("3. Update School Details");
        System.out.println("4. Delete School Details");
        System.out.println("5. Exit");

        switch (scanner.nextInt()) {
            case 1:
                schoolService.selectSchoolDetails(session);
                break;
            case 2:
                schoolService.insertSchoolDetails(session, scanner);
                break;
            case 3:
                schoolService.updateSchoolDetails(session, scanner);
                break;
            case 4:
                schoolService.deleteSchoolDetails(session, scanner);
                break;
            case 5:
                System.out.println("Exited");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Try Again.");
                break;
        }
    }

    private static void StudentDetails(Session session, StudentServiceImpl studentService, Scanner scanner) {
        System.out.println("***********WELCOME TO STUDENT DETAILS PAGE***********");
        System.out.println("1. Select Student Details");
        System.out.println("2. Insert Student Details");
        System.out.println("3. Update Student Details");
        System.out.println("4. Delete Student Details");
        System.out.println("5. Exit");

        switch (scanner.nextInt()) {
            case 1:
                studentService.selectStudentDetails(session);
                break;
            case 2:
          
                studentService.insertStudentDetails(session, scanner);
                break;
            case 3:
                studentService.updateStudentDetails(session, scanner);
                break;
            case 4:
                studentService.deleteStudentDetails(session, scanner);
                break;
            case 5:
                System.out.println("Exited");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Try Again.");
                break;
        }
    }

    private static void TeacherDetails(Session session, TeacherDetailsImpl teacherService, Scanner scanner) {
        System.out.println("***********WELCOME TO TEACHER DETAILS PAGE***********");
        System.out.println("1. Select Teacher Details");
        System.out.println("2. Insert Teacher Details");
        System.out.println("3. Update Teacher Details");
        System.out.println("4. Delete Teacher Details");
        System.out.println("5. Exit");

        switch (scanner.nextInt()) {
            case 1:
                teacherService.selectTeacherDetails(session);
                break;
            case 2:
                teacherService.insertTeacherDetails(session, scanner);
                break;
            case 3:
                teacherService.updateTeacherDetails(session, scanner);
                break;
            case 4:
                teacherService.deleteTeacherDetails(session, scanner);
                break;
            case 5:
                System.out.println("Exited");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Try Again.");
                break;
        }
    }

    private static void StudentGrades(Session session, GradesServicesImpl gradesService, Scanner scanner) {
        System.out.println("***********WELCOME TO STUDENT GRADES PAGE***********");
        System.out.println("1. Select Student Grades");
        System.out.println("2. Insert Student Grades");
        System.out.println("3. Update Student Grades");
        System.out.println("4. Delete Student Grades");
        System.out.println("5. Exit");

        switch (scanner.nextInt()) {
            case 1:
                gradesService.selectGradeDetails(session);
                break;
            case 2:
                gradesService.insertGradeDetails(session, scanner);
                break;
            case 3:
                gradesService.updateGradeDetails(session, scanner);
                break;
            case 4:
                gradesService.deleteGradeDetails(session, scanner);
                break;
            case 5:
                System.out.println("Exited");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Try Again.");
                break;
        }
    }

    private static void StudentAttendance(Session session, AttendanceImpl attendanceService, Scanner scanner) {
        System.out.println("***********WELCOME TO STUDENT ATTENDANCE PAGE***********");
        System.out.println("1. Select Student Attendance");
        System.out.println("2. Take Student Attendance");
        System.out.println("3. Update Student Attendance");
        System.out.println("4. Delete Student Attendance");
        System.out.println("5. Exit");

        switch (scanner.nextInt()) {
            case 1:
                attendanceService.selectAttendanceDetails(session);
                break;
            case 2:
                attendanceService.insertAttendanceDetails(session, scanner);
                break;
            case 3:
                attendanceService.updateAttendanceDetails(session, scanner);
                break;
            case 4:
                attendanceService.deleteAttendanceDetails(session, scanner);
                break;
            case 5:
                System.out.println("Exited");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Try Again.");
                break;
        }
      session.close();
  
      
    }
}
