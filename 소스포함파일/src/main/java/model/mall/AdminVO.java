package model.mall;

public class AdminVO {
	private String admin_id = null;
	private String admin_pw = null;
	
	public AdminVO(String id, String pw) {
		this.admin_id = id;
		this.admin_pw = pw;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	@Override
	public String toString() {
		return "AdminDTO [admin_id=" + admin_id + ", admin_pw=" + admin_pw + "]";
	}

}
