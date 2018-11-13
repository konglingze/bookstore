package rjxy.kcsj.klz.vo;

public class User {
	private	int UserNum;
	private String UserName ;
	private String Password ;
	private  int UserLevel ;
    public int getUserNum() {
		return UserNum;
	}
	public void setUserNum(int userNum) {
		UserNum = userNum;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getUserLevel() {
		return UserLevel;
	}
	public void setUserLevel(int userLevel) {
		UserLevel = userLevel;
	}
	
}
