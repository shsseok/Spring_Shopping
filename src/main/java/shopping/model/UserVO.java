package shopping.model;

import lombok.Getter;


public class UserVO {
	private int userId;
	private String userEmail;
	private String userName;
	private String userPassword;

	

	public UserVO(String userEmail,String userPassword,String userName) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
	}


	public int getUserId() {
		return userId;
	}

	
	public String getUserEmail() {
		return userEmail;
	}

	
	public String getUserPassword() {
		return userPassword;
	}

	
	public String getUserName() {
		return userName;
	}

}
