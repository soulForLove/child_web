package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.dao.ServiceInfoDao;
import com.lzt.asyn.sysmgr.model.ServiceInfo;

@Service
public class ServiceInfoService {

	@Autowired
	private ServiceInfoDao serviceInfoDao;

	public void saveOrUpdate(ServiceInfo param) {
		if (param.getServiceId() == null)
			insert(param);
		else
			update(param);
	}

	public void insert(ServiceInfo param) {
		serviceInfoDao.insert(param);
	}

	public void delete(Serializable id) {
		serviceInfoDao.delete(id);
	}

	public void update(ServiceInfo param) {
		serviceInfoDao.update(param);
	}

	public ServiceInfo getById(Serializable id) {
		ServiceInfo obj = serviceInfoDao.getById(id);
		return obj;
	}

	public List<ServiceInfo> queryByArgs(ServiceInfo param) {
		List<ServiceInfo> list = serviceInfoDao.queryByArgs(param);
		return list;
	}

	public long queryByArgsCount(ServiceInfo param) {
		return serviceInfoDao.queryByArgsCount(param);
	}

	public PageResult<ServiceInfo> queryPage(ServiceInfo req) {
		long count = serviceInfoDao.queryByArgsCount(req);
		List<ServiceInfo> list = count > 0 ? serviceInfoDao.queryByArgs(req)
				: new ArrayList<ServiceInfo>();
		return new PageResult<ServiceInfo>(count, list);
	}
}
