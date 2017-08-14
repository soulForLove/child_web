package com.lzt.asyn.sysmgr.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.sysmgr.model.Report;

@Repository
// 必须注解才能让mybatis的Report.xml配置文件映射到
public interface ReportDao {
	public void insert(Report param);

	public void delete(@Param("id") Serializable id);

	public void update(Report param);

	public Report getById(@Param("id") Serializable id);

	public List<Report> queryByArgs(Report param);

	public long queryByArgsCount(Report param);

	public long queryByUserCount(Report param);
}
