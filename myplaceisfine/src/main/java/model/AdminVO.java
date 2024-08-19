package model;

/**
 * @관리자 로그인 멤버변수 구현
 **/
public class AdminVO {
	private String admin_id;
	private String admin_pwd;
			
	public AdminVO() {

	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	@Override
	public String toString() {
		return "AdminVO [admin_id=" + admin_id + ", admin_pwd=" + admin_pwd + "]";
	}

}	//class AdminVO END
