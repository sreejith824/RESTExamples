package co.za.metropolitan.student.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -400606777147514993L;
	
	private String name;
	private long id;
	private int age;

	public StudentDTO() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
