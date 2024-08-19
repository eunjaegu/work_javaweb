package com.ej.dto;

/** 	Table의 record 하나를 객체화	**/
public class MemberVO {	 
	private int idx=0;	//멤버변수
	private String id=null;
	private String pw =null;
	
   
    public MemberVO() {	// 기본생성자
      
    }


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", id=" + id + ", pw=" + pw + "]";
	}


	
}
