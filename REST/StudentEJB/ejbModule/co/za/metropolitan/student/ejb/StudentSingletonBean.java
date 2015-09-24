package co.za.metropolitan.student.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class StudentSingletonBean implements StudentSingletonLocal {


	private Map<String, String> properties = new HashMap<String, String>();

	@PostConstruct
	public void init() {
		try {

			properties = lookupKhulaResourceReference();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, String> lookupKhulaResourceReference() {
		properties.put("Name", "Abcd");
		return properties;

	}

	public String getProperty(String propertyName) {
		return properties.get(propertyName);
	}

}
