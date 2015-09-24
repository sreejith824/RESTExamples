package co.za.metropolitan.login.dto;

public class LoginResponseDTO {
	private String status;
	private String  userName;
	public LoginResponseDTO() {
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
