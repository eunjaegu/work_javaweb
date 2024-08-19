package com.ej.db;

public class GuestVO {	 
	private int idx=0;//멤버변수
	private String name=null;
	private String title=null;
	private String contetn=null;
	private String moment=null;
	private int hit=0;
	
   
    public  GuestVO() {	// 기본생성자
      
    }


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContetn() {
		return contetn;
	}


	public void setContetn(String contetn) {
		this.contetn = contetn;
	}


	public String getMoment() {
		return moment;
	}


	public void setMoment(String moment) {
		this.moment = moment;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	@Override
	public String toString() {
		return "GuestVO [idx=" + idx + ", name=" + name + ", title=" + title + ", contetn=" + contetn + ", moment="
				+ moment + ", hit=" + hit + "]";
	}


	
	
}
