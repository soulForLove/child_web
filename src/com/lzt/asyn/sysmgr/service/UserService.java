package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.dao.UserDao;
import com.lzt.asyn.sysmgr.model.User;

@Service
public class UserService{
	public static final String HASH_ALGORITHM = "MD5";
	public static final int HASH_INTERATIONS = 2;
	public static final String HASH_SALT = "5bd6b9691273c47db7002fc80b5896";
	@Autowired
	private UserDao userDao;

	public void saveOrUpdate(User param) {
		if (param.getUserId() == null)
			insert(param);
		else
			update(param);
	}

	public void insert(User param) {
		userDao.insert(param);
	}

	public void delete(Serializable id) {
		userDao.delete(id);
	}

	public void update(User param) {
		userDao.update(param);
	}

	public User getById(Serializable id) {
		User obj = userDao.getById(id);
		return obj;
	}
	public List<User> queryByArgs(User param) {
		List<User> list = userDao.queryByArgs(param);
		return list;
	}
	public List<User> query() {
		return userDao.query();
	}
	public long queryByArgsCount(User param) {
		return userDao.queryByArgsCount(param);
	}
	public PageResult<User> queryPage(User req) {
		long count = userDao.queryByArgsCount(req);
		List<User> list = count > 0 ? userDao.queryByArgs(req) : new ArrayList<User>();
		return new PageResult<User>(count, list);
	}
	
	public User login(String loginName,String pasword) {
		return userDao.login(loginName, pasword);
	}
	public User sameUser(String loginName) {
		return userDao.sameUser(loginName);
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

	
}

