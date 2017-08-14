package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.dao.ReportDao;
import com.lzt.asyn.sysmgr.model.Report;

@Service
public class ReportService {

	@Autowired
	private ReportDao reportDao;

	public void saveOrUpdate(Report param) {
		if (param.getReportId() == null)
			insert(param);
		else
			update(param);
	}

	public void insert(Report param) {
		reportDao.insert(param);
	}

	public void delete(Serializable id) {
		reportDao.delete(id);
	}

	public void update(Report param) {
		reportDao.update(param);
	}

	public Report getById(Serializable id) {
		Report obj = reportDao.getById(id);
		return obj;
	}

	public List<Report> queryByArgs(Report param) {
		List<Report> list = reportDao.queryByArgs(param);
		return list;
	}
	
	public long queryByArgsCount(Report param) {
		return reportDao.queryByArgsCount(param);
	}
	public long queryByUserCount(Report param) {
		return reportDao.queryByUserCount(param);
	}

	public PageResult<Report> queryPage(Report req) {
		long count = reportDao.queryByArgsCount(req);
		List<Report> list = count > 0 ? reportDao.queryByArgs(req)
				: new ArrayList<Report>();
		return new PageResult<Report>(count, list);
	}

}
