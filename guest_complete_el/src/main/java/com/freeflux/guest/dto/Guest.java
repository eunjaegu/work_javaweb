package com.freeflux.guest.dto;

import java.sql.Date;
/** 1개 레코드를 객체화 : dto 역할 **/
public class Guest {
	private int idx=0;
	private String name=null;
	private String title=null;
	private String content=null;
	private Date moment=null;
	private int hit=0;

	public Guest() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
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
		return "Guest [idx=" + idx + ", name=" + name + ", title=" + title + ", content=" + content + ", moment="
				+ moment + ", hit=" + hit + "]";
	}

	
}
