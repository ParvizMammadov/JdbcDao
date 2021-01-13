package com.parviz;

import java.util.Scanner;

import com.parviz.dao.StudentDao;
import com.parviz.model.Student;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose one option:");
		System.out.println("1. Show all students");
		System.out.println("2. Add a student");
		System.out.println("3. Fetch a student");
		
		StudentDao dao = new StudentDao();
		dao.connect();
		
		int op = sc.nextInt();
		switch (op) {
		case 1:
			dao.showAll();
			break;
		case 2:
			Student s = new Student();
			System.out.println("Enter student id:");
			s.setId(sc.nextInt());
			System.out.println("Enter student name:");
			sc.nextLine();
			s.setName(sc.next());
			System.out.println("Enter student city:");
			s.setCity(sc.next());
			dao.addStudent(s);
			System.out.println("Student added successfully");
			break;
		case 3:
			System.out.println("Enter student id:");
			int id = sc.nextInt();
			Student s1 = new Student();
			s1 = dao.getStudent(id);
			System.out.println(s1);
			break;

		default:
			System.out.println("Choose a right option");
			break;
		}
		
		sc.close();
		
	}

}
