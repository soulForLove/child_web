package com.lzt.asyn.back.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.model.User;
import com.lzt.asyn.sysmgr.service.UserService;

@Controller
@RequestMapping("/sysmgr")
public class UserController extends BaseController {

	@Autowired
	private UserService smUserService;

	@RequestMapping(value = "/pageQueryUser", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<User> pageQuerySmUser(@RequestBody User req) {
		return smUserService.queryPage(req);
	}

	@RequestMapping(value = "/saveOrUpdateUser")
	@ResponseBody
	public void saveOrUpdate(@RequestBody User task) {
		smUserService.saveOrUpdate(task);
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmUser(@PathVariable("id") Serializable id) {
		smUserService.delete(id);
	}

	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public User getByIdSmUser(@PathVariable("id") Serializable id) {
		return smUserService.getById(id);
	}

}
