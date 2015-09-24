package co.za.metropolitan.login;

import javax.ejb.Local;

import co.za.metropolitan.login.dto.LoginDTO;
import co.za.metropolitan.login.dto.LoginResponseDTO;
@Local
public interface LoginManagerLocal {
	LoginResponseDTO login(LoginDTO loginDTO);
}
