package db.mall;

public interface ProductQuerys {
	String productAll = "Select * from tblProduct";
	String productCount = "select count(no) as total from tblproduct";
	String productOne = "select * from tblproduct where no = ?";
	String productInsert = "insert into tblproduct (name, price, detail, date, stock, image) " +
			"values (?, ?, ?, now(), ?, ?)";
	String productUpdate = "update tblproduct set name = ?, price = ?, detail =?, stock=?, date = now(), image = ? where no=?";
	String productDelete = "delete from tblproduct where no = ?";
}
