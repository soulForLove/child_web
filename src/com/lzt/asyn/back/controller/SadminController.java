package com.lzt.asyn.back.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.sysmgr.model.SuperAdmin;
import com.lzt.asyn.sysmgr.service.SuperAdminService;

@Controller
@RequestMapping("/Sadmin")
public class SadminController extends BaseController {

	@Autowired
	private SuperAdminService adminService;
	@RequestMapping(value = "/saveOrUpdateAdmin")
	@ResponseBody
	public void saveOrUpdate(@RequestBody SuperAdmin task,HttpServletRequest request) {
		task.setPassword(adminService.entryptPassword(task.getPassword()));
		adminService.saveOrUpdate(task);
	}
	@RequestMapping(value = "/UpdateAdmin")
	@ResponseBody
	public void UpdateAdmin(@RequestBody SuperAdmin task,HttpServletRequest request) {
		adminService.saveOrUpdate(task);
		if(task.getSuperAdminId()!=null){
			SuperAdmin a=adminService.login(task.getLoginName(), task.getPassword());
			HttpSession session = request.getSession();
			session.removeAttribute("loginSAdmin");
			session.setAttribute("loginSAdmin", a);
		}
	}
	@RequestMapping(value = "/getAdminById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public SuperAdmin getByIdSmAdmin(@PathVariable("id") Serializable id) {
		return adminService.getById(id);
	}

	@RequestMapping(value = "/valid")
	@ResponseBody
	public SuperAdmin valid(@RequestBody SuperAdmin task) {
		SuperAdmin u=adminService.sameUser(task.getLoginName());
		return u;
	}
}
