package com.sujata.persistence;

import com.sujata.beans.Course;
import com.sujata.beans.Employee;
import com.sujata.database.CourseDataBase;
import com.sujata.exceptions.CourseNotFoundException;

public class CourseDaoImpl implements CourseDao {

	private CourseDataBase courseDataBase=new CourseDataBase();
	
	@Override
	public Course[] getAllCourses() {
		return courseDataBase.getCourses();
	}

	@Override
	public Course searchCourseById(String cId)throws CourseNotFoundException {
		for(Course course:courseDataBase.getCourses()) {
			if(course.getCourseId().equals(cId))
				return course;
		}
		throw new CourseNotFoundException("Course with course id "+cId+" does not exist");
	}

	@Override
	public boolean addEmployeeForCourseId(String cID, Employee employee) throws CourseNotFoundException {
		int index=0;
		Course[] courses=courseDataBase.getCourses();
		for(Course course:courses) {
			if(course.getCourseId().equals(cID)) {
				Employee[] employees=courses[index].getEmployees();
				
				employees[course.getEmpCount()]=employee;	
				courses[index].setEmployees(employees);
				
				int count=courses[index].getEmpCount();
				courses[index].setEmpCount(count+1);
				
				return true;
			}
			index++;
		}
		throw new CourseNotFoundException("Course with id "+cID+" doesnot exist!");
	}

	
	public boolean deleteEmployeeForCourseId(int eId,String cId) {
		int i=0,index=0;
		boolean flag=false;
		Course[] course = courseDataBase.getCourses();
		for(index=0;index<course.length;i++)
		{
			if(course[index].getCourseId().equalsIgnoreCase(cId))
			{
				for(i=0 ; i<course[index].getEmployees().length;i++)
				{
					if(course[index].getEmployees()[i].getEmpId() == eId)
					{
						flag = true;
						break;
					}
				}
			}
			if(flag)
				break;
		}
		if(!flag)
			return false;
		course[index].getEmployees()[i] = null;
		for(int k=i;k<course[index].getEmployees().length-1;k++)
		{
			course[index].getEmployees()[k] = course[index].getEmployees()[k+1];
			course[index].getEmployees()[k+1] = null;
		}
		return true;
	}

	
}
