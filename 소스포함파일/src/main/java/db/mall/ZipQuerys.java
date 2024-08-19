package db.mall;

public interface ZipQuerys {
	String searchAddr = "select zipcode, area1, area2, area3 from tblzipcode ";
	String addrWhereSQL = "where area3 like CONCAT('%', ?, '%')";
}
