package db.mall;

public interface MemberQuerys {
	String selectAll = "select * from tblMember";
	String memberID = "SELECT * FROM tblMember WHERE ID = ?";
	String insertMem = "insert into tblmember values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String updateMem = "update tblmember set pwd = ?, name = ?, gender = ?, birthday = ?, "
			+ "email = ?, zipcode = ?, address = ?, hobby = ?, job = ? "
			+ "where id = ?";
		
}
