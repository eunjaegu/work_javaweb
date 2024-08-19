package db.mall;

public interface AdminQuerys {
	String adminID = "select * from tbladmin where admin_id = ?";
	String orderAll = "SELECT o.no, o.id, p.name, o.quantity, o.date, o.state FROM tblorder o JOIN tblproduct p ON o.productno = p.no";
	String orderOne = "SELECT o.no, o.id, p.name, o.quantity, o.date, o.state, "
			+ "o.productNo, p.price, p.stock "
			+"FROM tblorder o JOIN tblproduct p ON o.productno = p.no where o.no = ?";
	String updateOrder = "update tblorder set state = ? where no = ?";
	String deleteOrder = "delete FROM tblorder where no = ?";
}
