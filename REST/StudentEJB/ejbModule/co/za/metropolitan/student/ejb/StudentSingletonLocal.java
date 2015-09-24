package co.za.metropolitan.student.ejb;

import javax.ejb.Local;

@Local
public interface StudentSingletonLocal {
	
	String getProperty(String propertyName);

}
