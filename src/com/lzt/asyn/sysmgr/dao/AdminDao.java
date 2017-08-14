package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.model.User;

@Repository
// 必须注解才能让mybatis的admin.xml配置文件映射到
public interface AdminDao {
	public void insert(Admin param);

	public void delete(@Param("id") Serializable id);

	public void update(Admin param);

	public Admin getById(@Param("id") Serializable id);

	public List<Admin> queryByArgs(Admin param);

	public long queryByArgsCount(Admin param);

	public Admin login(@Param("login_name") String login_name,@Param("password") String password);// 登录
	public Admin sameUser(@Param("login_name")String loginName);
}
