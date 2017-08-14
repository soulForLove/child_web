
package com.lzt.asyn.sysmgr.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.SmResource;


@Repository
public interface SmResourceDao{

	public List<SmResource> queryAll();
	public List<SmResource> queryAllLeftJoinRoleId(@Param("roleId") Integer roleId);
	public List<SmResource> queryByRoleId(@Param("roleId") Integer roleId);
	public List<SmResource> queryByUserId(@Param("userId") Long userId);
//	public void insert(SmResource param);
//	public void delete(@Param("id") Serializable id);
//	public void update(SmResource param);
//	public SmResource getById(@Param("id") Serializable id);
//	public List<SmResource> queryByArgs(SmResourceReq param);
//	public int queryByArgsCount(SmResourceReq param);
	
}
