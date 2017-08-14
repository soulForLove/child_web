package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.Discuss;

@Repository
// 必须注解才能让mybatis的Discuss.xml配置文件映射到
public interface DiscussDao {
	public void insert(Discuss param);

	public void delete(@Param("id") Serializable id);
	
	public void deleteByNewsId(@Param("id") Serializable id);

	public void update(Discuss param);

	public Discuss getById(@Param("id") Serializable id);

	public List<Discuss> queryByArgs(Discuss param);

	public long queryByArgsCount(Discuss param);

}
