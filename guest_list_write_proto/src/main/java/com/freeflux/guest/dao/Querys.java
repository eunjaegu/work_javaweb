package com.freeflux.guest.dao;

public interface Querys {
	static final String TABLE_NAME = "guest";
	public final String SELECT_ALL = "select idx, name, title, moment, hit from "+ TABLE_NAME + " order by idx desc"; //order by 정렬 idx desc 번호 역순 //content 제외하고
	public final String SELECT_ONE = "select * from "+ TABLE_NAME + "  where idx=?"; // 게시글 100개 중에 하나를 골라야함.
	public final String INSERT = "insert into " + TABLE_NAME + " (name, title, content, moment, hit) values (?, ?, ?, now(), 0)" ;
	public final String UPDATE = "update " + TABLE_NAME + " set title=? , content=? where = idx=?"; 
	public final String DELETE = "delete from " + TABLE_NAME + " where = idx=?";
}
