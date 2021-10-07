package com.sujata.database;

import java.util.ArrayList;

import com.sujata.beans.Course;

public class CourseDataBase {

	private static ArrayList<Course> courses=new ArrayList<>();

	static {
		courses.add(0,new Course("C001", "JAVA", 20000, true, true));
		courses.add(1,new Course("C002", "Spring", 30000, true, false));
		courses.add(2,new Course("C003", "Hibernate", 25000, true, false));
		courses.add(3,new Course("C004", "React JS", 40000, true, true));
		courses.add(4,new Course("C005", "Angular JS", 50000, true, true));
		
	}
	public static ArrayList<Course> getCourses() {
		return courses;
	}

	public static void setCourses(ArrayList<Course> courses) {
		CourseDataBase.courses = courses;
	}
	
}
