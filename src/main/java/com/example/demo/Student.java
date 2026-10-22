package com.example.demo;

public class Student {
	
	private int id;
	private String name;
	private String course;
	
	public Student() {}
	
	public Student(int id, String name, String course){
		this.id = id;
		this.name = name;
		this.course = course;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCourse() {
		return course;
	}

	public void setName(String name2) {
		// TODO Auto-generated method stub
		this.name = name2;
	}

	public void setCourse(String course2) {
		// TODO Auto-generated method stub
		this.course = course2;
	}

	public void setId(int i) {
		// TODO Auto-generated method stub
		this.id = i;
	}
}
