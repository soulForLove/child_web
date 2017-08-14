package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.model.SuperAdmin;

@Repository
// 必须注解才能让mybatis的admin.xml配置文件映射到
public interface SuperAdminDao {
	public void insert(SuperAdmin param);

	public void delete(@Param("id") Serializable id);

	public void update(SuperAdmin param);

	public SuperAdmin getById(@Param("id") Serializable id);

	public List<SuperAdmin> queryByArgs(SuperAdmin param);

	public long queryByArgsCount(SuperAdmin param);

	public SuperAdmin login(@Param("login_name") String login_name,
			@Param("password") String password);// 登录
	public SuperAdmin sameUser(@Param("login_name")String loginName);
}
