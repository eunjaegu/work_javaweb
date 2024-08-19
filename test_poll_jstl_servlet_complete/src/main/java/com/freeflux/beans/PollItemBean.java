package com.freeflux.beans;

import java.util.Arrays;

public class PollItemBean {

	private int listnum; 		// 설문 번호
	private int itemnum; 		// 아이템 번호
	private String [] item; 	// 아이템 내용
	private int count; 			// 투표수
	
	private String hRGB;
	private int ratio;
	
	public PollItemBean() {
	}

	@Override
	public String toString() {
		return "PollItemBean [listnum=" + listnum + ", itemnum=" + itemnum + ", item=" + Arrays.toString(item)
				+ ", count=" + count + "]";
	}
	
	public int getListnum() {
		return listnum;
	}
	public void setListnum(int listnum) {
		this.listnum = listnum;
	}
	public int getItemnum() {
		return itemnum;
	}
	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}
	public String[] getItem() {
		return item;
	}
	public void setItem(String[] item) {
		this.item = item;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public String gethRGB() {
		return hRGB;
	}

	public void sethRGB(String hRGB) {
		this.hRGB = hRGB;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}
	
}