package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.dao.SuperAdminDao;
import com.lzt.asyn.sysmgr.dao.SuperAdminDao;
import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.model.SuperAdmin;
import com.lzt.asyn.common.service.BaseService;

@Service
public class SuperAdminService extends BaseService<SuperAdmin> {
	public static final String HASH_ALGORITHM = "MD5";
	public static final int HASH_INTERATIONS = 2;
	public static final String HASH_SALT = "5bd6b9691273c47db7002fc80b5896";

	@Autowired
	private SuperAdminDao sAdminDao;

	public void saveOrUpdate(SuperAdmin param) {
		if (param.getSuperAdminId() == null)
			insert(param);
		else
			update(param);
	}

	public void insert(SuperAdmin param) {
		sAdminDao.insert(param);
	}

	public void delete(Serializable id) {
		sAdminDao.delete(id);
	}

	public void update(SuperAdmin param) {
		sAdminDao.update(param);
	}

	public SuperAdmin getById(Serializable id) {
		SuperAdmin obj = sAdminDao.getById(id);
		return obj;
	}

	public List<SuperAdmin> queryByArgs(SuperAdmin param) {
		List<SuperAdmin> list = sAdminDao.queryByArgs(param);
		return list;
	}

	public SuperAdmin login(String name, String password) {
		return this.sAdminDao.login(name, password);
	}

	public long queryByArgsCount(SuperAdmin param) {
		return sAdminDao.queryByArgsCount(param);
	}

	public PageResult<SuperAdmin> queryPage(SuperAdmin req) {
		long count = sAdminDao.queryByArgsCount(req);
		List<SuperAdmin> list = count > 0 ? sAdminDao.queryByArgs(req)
				: new ArrayList<SuperAdmin>();
		return new PageResult<SuperAdmin>(count, list);
	}
	public SuperAdmin sameUser(String loginName) {
		return sAdminDao.sameUser(loginName);
	}
	/**
	 * 生成安全的密码
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] hashPassword = com.lzt.asyn.common.security.Digests.md5(plainPassword.getBytes(), HASH_SALT.getBytes(), HASH_INTERATIONS);
		return com.wp.stone.common.utils.Encodes.encodeHex(hashPassword);
	}
	
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		return password.equals(entryptPassword(plainPassword));
	}

	@Override
	protected void translate(SuperAdmin obj) {
		// TODO Auto-generated method stub
		
	}

}
