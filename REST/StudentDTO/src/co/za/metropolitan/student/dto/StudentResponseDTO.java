package co.za.metropolitan.student.dto;

import java.io.Serializable;

public class StudentResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -400606777147514993L;
	
	private String name;

	public StudentResponseDTO() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
