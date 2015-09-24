package co.za.metropolitan.login.ejb;

import javax.ejb.Stateless;

import co.za.metropolitan.login.LoginManagerLocal;
import co.za.metropolitan.login.dto.LoginDTO;
import co.za.metropolitan.login.dto.LoginResponseDTO;

/**
 * Session Bean implementation class LoginManagerEJB
 */
@Stateless
public class LoginManagerEJB implements LoginManagerLocal {

	/**
	 * Default constructor.
	 */
	public LoginManagerEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LoginResponseDTO login(LoginDTO loginDTO) {
		String isLoggedin = "failure";
		if (loginDTO.getUsername().equalsIgnoreCase("A0690120") && loginDTO.getPassword().equalsIgnoreCase("password")) {
			isLoggedin = "success";
		}
		LoginResponseDTO responseDTO = new LoginResponseDTO();
		responseDTO.setStatus(isLoggedin);
		return responseDTO;
	}

}
