package model;

/**
 * @관리자 및 사용자 아이디 세션 멤버변수 구현   
 **/
public class SessionVO {
	private String admin_id;
	private String user_id;
	
	public SessionVO() {
		
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "SessionVO [admin_id=" + admin_id + ", user_id=" + user_id + "]";
	}

}//class SessionVO END
