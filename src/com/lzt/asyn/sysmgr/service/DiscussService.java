package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.dao.DiscussDao;
import com.lzt.asyn.sysmgr.model.Discuss;

@Service
public class DiscussService {

	@Autowired
	private DiscussDao discussDao;

	public void saveOrUpdate(Discuss param) {
		if (param.getDiscussId() == null)
			insert(param);
		else
			update(param);
	}

	public void insert(Discuss param) {
		discussDao.insert(param);
	}

	public void delete(Serializable id) {
		discussDao.delete(id);
	}
	
	public void deleteByNewsId(Serializable id) {
		discussDao.deleteByNewsId(id);
	}

	public void update(Discuss param) {
		discussDao.update(param);
	}

	public Discuss getById(Serializable id) {
		Discuss obj = discussDao.getById(id);
		return obj;
	}

	public List<Discuss> queryByArgs(Discuss param) {
		List<Discuss> list = discussDao.queryByArgs(param);
		return list;
	}

	public long queryByArgsCount(Discuss param) {
		return discussDao.queryByArgsCount(param);
	}

	public PageResult<Discuss> queryPage(Discuss req) {
		long count = discussDao.queryByArgsCount(req);
		List<Discuss> list = count > 0 ? discussDao.queryByArgs(req)
				: new ArrayList<Discuss>();
		return new PageResult<Discuss>(count, list);
	}

}
