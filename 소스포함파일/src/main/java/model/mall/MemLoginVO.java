package model.mall;

public class MemLoginVO {
	private String mem_id = null;
	private String mem_pw = null;
	
	public MemLoginVO(String id, String pw) {
		this.mem_id = id;
		this.mem_pw = pw;
	}

	public String getMem_id() {
		return mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	@Override
	public String toString() {
		return "MemLoginVO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + "]";
	}

}
