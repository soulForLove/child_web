package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.Adver;

@Repository
public interface AdverDao {
	public void insert(Adver param);

	public void delete(@Param("id") Serializable id);
	
	public void deleteByBookId(@Param("id") Serializable id);

	public void update(Adver param);

	public List<Adver> query();

	public Adver getById(@Param("id") Serializable id);// 按id号取值

	public List<Adver> queryByArgs(Adver param);

	public long queryByArgsCount(Adver param);

}
