package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.dao.AdminDao;
import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.model.User;
import com.lzt.asyn.common.service.BaseService;

@Service
public class AdminService extends BaseService<Admin> {
	public static final String HASH_ALGORITHM = "MD5";
	public static final int HASH_INTERATIONS = 2;
	public static final String HASH_SALT = "5bd6b9691273c47db7002fc80b5896";

	@Autowired
	private AdminDao adminDao;

	public void saveOrUpdate(Admin param) {
		if (param.getAdminId() == null)
			insert(param);
		else
			update(param);
	}

	public void insert(Admin param) {
		adminDao.insert(param);
	}

	public void delete(Serializable id) {
		adminDao.delete(id);
	}

	public void update(Admin param) {
		adminDao.update(param);
	}

	public Admin getById(Serializable id) {
		Admin obj = adminDao.getById(id);
		return obj;
	}

	public List<Admin> queryByArgs(Admin param) {
		List<Admin> list = adminDao.queryByArgs(param);
		return list;
	}

	public Admin login(String name, String password) {
		return this.adminDao.login(name, password);
	}

	public long queryByArgsCount(Admin param) {
		return adminDao.queryByArgsCount(param);
	}

	public PageResult<Admin> queryPage(Admin req) {
		long count = adminDao.queryByArgsCount(req);
		List<Admin> list = count > 0 ? adminDao.queryByArgs(req)
				: new ArrayList<Admin>();
		return new PageResult<Admin>(count, list);
	}
	public Admin sameUser(String loginName) {
		return adminDao.sameUser(loginName);
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
	protected void translate(Admin obj) {
		// TODO Auto-generated method stub
		
	}

}
