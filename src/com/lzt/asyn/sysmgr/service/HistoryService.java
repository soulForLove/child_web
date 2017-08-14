package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.dao.HistoryDao;
import com.lzt.asyn.sysmgr.model.History;
import com.lzt.asyn.common.service.BaseService;

@Service
public class HistoryService extends BaseService<History> {
	

	@Autowired
	private HistoryDao historyDao;

	public void saveOrUpdate(History param) {
		if (param.getHisId() == null)
			insert(param);
		else
			update(param);
	}

	public void insert(History param) {
		historyDao.insert(param);
	}

	public void delete(Serializable id) {
		historyDao.delete(id);
	}

	public void update(History param) {
		historyDao.update(param);
	}

	public History getById(Serializable id) {
		History obj = historyDao.getById(id);
		return obj;
	}

	public List<History> queryByArgs(History param) {
		List<History> list = historyDao.queryByArgs(param);
		return list;
	}


	public long queryByArgsCount(History param) {
		return historyDao.queryByArgsCount(param);
	}

	public PageResult<History> queryPage(History req) {
		long count = historyDao.queryByArgsCount(req);
		List<History> list = count > 0 ? historyDao.queryByArgs(req)
				: new ArrayList<History>();
		return new PageResult<History>(count, list);
	}

	@Override
	protected void translate(History obj) {
		// TODO Auto-generated method stub
		
	}
	

}
