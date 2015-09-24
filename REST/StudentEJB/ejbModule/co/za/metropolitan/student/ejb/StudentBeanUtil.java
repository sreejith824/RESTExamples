package co.za.metropolitan.student.ejb;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import co.za.metropolitan.student.dto.StudentDTO;
import co.za.metropolitan.student.dto.StudentResponseDTO;
import co.za.metropolitan.student.threadlocal.ApplicationSecurityContext;

@Singleton
public class StudentBeanUtil {

	private static ObjectMapper mapper = new ObjectMapper().configure(
			DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	StudentSingletonLocal studentSingletonLocal;

	@PostConstruct
	public void initialize() {
		InitialContext initialContext = null;
		try {
			initialContext = new InitialContext();
			studentSingletonLocal = (StudentSingletonLocal) initialContext
					.lookup("java:module/StudentSingletonBean");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StudentBeanUtil() {

	}

	public String getName(String name) {

		
		String propertyName = studentSingletonLocal.getProperty(name);
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(propertyName);
		String responseName = getNameFromExternalService(studentDTO).getName();
		return responseName;
	}

	private StudentResponseDTO getNameFromExternalService(StudentDTO studentDTO) {
		StringBuilder uriBuilder = new StringBuilder(
				"http://localhost:9083/HelloWorldMessageListeningMediationWeb/HelloWorldMessageListeningHttpExport/readMesasge");
		StudentResponseDTO studentResponseDTO = null;
		try {
			Object studentDTOObject = connectToRESTInterface(uriBuilder.toString(), studentDTO);
			// Object studentDTOObject = getStudentResponseMap.get("name");
			String studentDTOObjectJsonString;
			studentDTOObjectJsonString = mapper.writeValueAsString(studentDTOObject);
			studentResponseDTO = mapper.readValue(studentDTOObjectJsonString,StudentResponseDTO.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return studentResponseDTO;

	}

	private <T> T connectToRESTInterface(String URL, Object fromObject) 
		throws JsonGenerationException, JsonMappingException, IOException {
		
		String securityToken = ApplicationSecurityContext.getSecurityToken();
		System.out.println("Security Token : " + securityToken);

		Object responseObject = null;
		ClientConfig clientConfig = new ClientConfig();

        RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(URL);
		resource.cookie(securityToken);
		
		String postData = mapper.writeValueAsString(fromObject);
		ClientResponse clientResponse = resource.contentType(
				MediaType.APPLICATION_JSON).post(postData);
		clientResponse.getStatusCode();
		String responseString = clientResponse.getEntity(String.class);

		responseObject = mapper.readValue(responseString,
				new TypeReference<T>() {
				});

		return (T) responseObject;
	}

}
