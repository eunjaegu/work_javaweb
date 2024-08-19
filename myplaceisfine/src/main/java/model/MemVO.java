package model;

/**
 * @회원 로그인 및 회원가입 멤버변수 구현
 **/
public class MemVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone;
	private String mem_email;
	
	public MemVO() {
		
	}

	public String getmem_id() {
		return mem_id;
	}

	public void setmem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getmem_pwd() {
		return mem_pwd;
	}

	public void setmem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getmem_name() {
		return mem_name;
	}

	public void setmem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getmem_phone() {
		return mem_phone;
	}

	public void setmem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getmem_email() {
		return mem_email;
	}

	public void setmem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	@Override
	public String toString() {
		return "MemVO [mem_id=" + mem_id + ", mem_pwd=" + mem_pwd + ", mem_name=" + mem_name + ", mem_phone="
				+ mem_phone + ", mem_email=" + mem_email + "]";
	}

}	//class MemVO END
