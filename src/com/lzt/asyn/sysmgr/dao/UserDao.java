package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.User;

@Repository
public interface UserDao {
	public void insert(User param);
	public void delete(@Param("id") Serializable id);
	public void update(User param);
	public User getById(@Param("id") Serializable id);
	public List<User> queryByArgs(User param);
	public long queryByArgsCount(User param);
	public List<User> query(); 
	public User login(@Param("loginName")String loginName,@Param("password")String password);
	public User sameUser(@Param("loginName")String loginName);
}
