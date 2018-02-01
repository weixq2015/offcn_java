package com.offcn.pojo;

import java.util.List;

public class CourseExt extends Course {

	private Classes classes;
	
	private Teacher teacher;
	
	private Student student;
	
	private List<String> cids;

	public List<String> getCids() {
		return cids;
	}

	public void setCids(List<String> cids) {
		this.cids = cids;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
