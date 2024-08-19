package com.freeflux.guest.dao;

public interface Querys {
	static final String TABLE_NAME = "guest";
	public final String SELECT_ALL = "select idx, name, title, moment, hit from "+ TABLE_NAME + " order by idx desc";
	public final String SELECT_ONE = "select * from "+ TABLE_NAME + "  where idx=?";
	public final String UPDATE_HIT = "update " + TABLE_NAME + " set hit=hit+1 where idx=?";
	public final String INSERT = "insert into " + TABLE_NAME + " (name, title, content, moment, hit) values (?, ?, ?, now(), 0)" ;
	public final String UPDATE = "update " + TABLE_NAME + " set title=? , content=?, moment=now()  where idx=?"; 
	public final String DELETE = "delete from " + TABLE_NAME + " where idx=?";
}
