package model.board;

public class BoardModel {

	private int num;
	private String subject;
	private String writer;
	private String contents;
	private String ip;
	private int hit = 0;
	private String regDate;
	private String modDate;
	private String pageNum;
	private String searchType="";
	private String searchText="";
	private int listCount;
	private int pagePerBlock = 10;
	
	
	public BoardModel() {
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getModDate() {
		return modDate;
	}


	public void setModDate(String modDate) {
		this.modDate = modDate;
	}


	public String getPageNum() {
		return pageNum;
	}


	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public String getSearchText() {
		return searchText;
	}


	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
	}


	public int getPagePerBlock() {
		return pagePerBlock;
	}


	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}


	@Override
	public String toString() {
		return "BoardModel [num=" + num + ", subject=" + subject + ", writer=" + writer + ", contents=" + contents
				+ ", ip=" + ip + ", hit=" + hit + ", regDate=" + regDate + ", modDate=" + modDate + ", pageNum="
				+ pageNum + ", searchType=" + searchType + ", searchText=" + searchText + ", listCount=" + listCount
				+ ", pagePerBlock=" + pagePerBlock + "]";
	}

}
