package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.ServiceInfo;

@Repository
// 必须注解才能让mybatis的ServiceInfo.xml配置文件映射到
public interface ServiceInfoDao {
	public void insert(ServiceInfo param);

	public void delete(@Param("id") Serializable id);

	public void update(ServiceInfo param);

	public ServiceInfo getById(@Param("id") Serializable id);

	public List<ServiceInfo> queryByArgs(ServiceInfo param);

	public long queryByArgsCount(ServiceInfo param);
	
}
