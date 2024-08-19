package model.mall;

public class AddressVO {
	private String zipcode = null;
	private String area1 = null;
	private String area2 = null;
	private String area3 = null;
	
	public AddressVO() {
		
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getArea1() {
		return area1;
	}

	public String getArea2() {
		return area2;
	}

	public String getArea3() {
		return area3;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	public void setArea3(String area3) {
		this.area3 = area3;
	}

	@Override
	public String toString() {
		return "AddressVO [zipcode=" + zipcode + ", area1=" + area1 + ", area2=" + area2 + ", area3=" + area3 + "]";
	}

}
