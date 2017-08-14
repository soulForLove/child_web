package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.History;

@Repository
public interface HistoryDao {
	
	public void insert(History param);

	public void delete(@Param("id") Serializable id);

	public void update(History param);

	public History getById(@Param("id") Serializable id);

	public List<History> queryByArgs(History param);

	public long queryByArgsCount(History param);

}
