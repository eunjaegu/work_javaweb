package model.mall;

public class MemInfoVO {
	private String id = null;
	private String pwd = null;
	private String name = null;
	private String gender = null;
	private String birthday = null;
	private String email = null;
	private String zipcode = null;
	private String address = null;
	private String hobby = null;
	private String job = null;
	

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getAddress() {
		return address;
	}

	public String getHobby() {
		return hobby;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "MemInfoVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", email=" + email + ", zipcode=" + zipcode + ", address=" + address + ", hobby=" + hobby
				+ ", job=" + job + "]";
	}

}
