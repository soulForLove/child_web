package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.Book;
import com.lzt.asyn.sysmgr.model.User;
@Repository
public interface BookDao {
	public void insert(Book param);

	public void delete(@Param("id") Serializable id);

	public void update(Book param);

	public Book getById(@Param("id") Serializable id);// 按id号取值

	public List<Book> query(); 
	public List<Book> queryByArgs(Book param);

	public long queryByArgsCount(Book param);

}
