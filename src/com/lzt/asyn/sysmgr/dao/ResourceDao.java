
package com.lzt.asyn.sysmgr.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.Resource;

@Repository
public interface ResourceDao{

	public List<Resource> queryAll();
	public List<Resource> queryAllLeftJoinRoleId(@Param("roleId") Integer roleId);
	public List<Resource> queryByRoleId(@Param("roleId") Integer roleId);
	public List<Resource> queryByUserId(@Param("userId") Long userId);
//	public void insert(Resource param);
//	public void delete(@Param("id") Serializable id);
//	public void update(Resource param);
//	public Resource getById(@Param("id") Serializable id);
//	public List<Resource> queryByArgs(ResourceReq param);
//	public int queryByArgsCount(ResourceReq param);
	
}
