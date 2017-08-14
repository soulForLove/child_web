package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.News;
@Repository
public interface NewsDao {
	public void insert(News param);

	public void delete(@Param("id") Serializable id);

	public void update(News param);

	public News getById(@Param("id") Serializable id);// 按id号取值

	public List<News> query(); 

	public List<News> queryByArgs(News param);

	public long queryByArgsCount(News param);
	
}
