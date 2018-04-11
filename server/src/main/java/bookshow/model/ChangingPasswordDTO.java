package bookshow.model;

public class ChangingPasswordDTO {
	private String username;
	private String newPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public ChangingPasswordDTO(){}
	
	public ChangingPasswordDTO(String username, String newPassword) {
		super();
		this.username = username;
		this.newPassword = newPassword;
	}
	
	

}
