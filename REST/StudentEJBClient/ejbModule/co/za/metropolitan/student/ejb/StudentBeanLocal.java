package co.za.metropolitan.student.ejb;

import javax.ejb.Local;

import co.za.metropolitan.student.dto.StudentDTO;

@Local
public interface StudentBeanLocal {
	long addStudent(StudentDTO studentDTO);
	StudentDTO getStudent(String id);
}
