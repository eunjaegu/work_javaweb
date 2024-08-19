package model.mall;
/**
 	관리자 상품 모델 클래스
**/
public class AdminProductModel {
	/** 번호 **/
	private int num;
	/** 상품 이름 **/
	private String name;
	/** 가격 **/
	private int price;
	/** 상세 정보 **/
	private String detail;
	/** 등록일시 **/
	private String date;
	/** 재고 **/
	private int stock;
	/** 이미지 **/
	private String img;
	
	public AdminProductModel() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ProductModel [num=" + num + ", name=" + name + ", price=" + price + ", detail=" + detail + ", date="
				+ date + ", stock=" + stock + ", img=" + img + "]";
	}
	
}
