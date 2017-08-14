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

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.service.AdminService;

@Controller
@RequestMapping("/admin")//管理员控制类
public class AdminController extends BaseController {

	@Autowired
	private AdminService adminService;
	@RequestMapping(value = "/saveOrUpdateAdmin")
	@ResponseBody
	public void saveOrUpdate(@RequestBody Admin task,HttpServletRequest request) {
		task.setPassword(adminService.entryptPassword(task.getPassword()));
		adminService.saveOrUpdate(task);
	}

	@RequestMapping(value = "/UpdateAdmin")
	@ResponseBody
	public void UpdateAdmin(@RequestBody Admin task,HttpServletRequest request) {
		adminService.saveOrUpdate(task);
		if(task.getAdminId()!=null){
			Admin a=adminService.login(task.getLoginName(), task.getPassword());
			HttpSession session = request.getSession();
			session.removeAttribute("loginadmin");
			session.setAttribute("loginadmin", a);
		}
	}
	@RequestMapping(value = "/pageQueryAdmin", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<Admin> pageQuerySmAdmin(@RequestBody Admin req) {
		return adminService.queryPage(req);
	}

	@RequestMapping(value = "/deleteAdmin/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmAdmin(@PathVariable("id") Serializable id) {
		adminService.delete(id);
	}

	@RequestMapping(value = "/getAdminById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Admin getByIdSmAdmin(@PathVariable("id") Serializable id) {
		return adminService.getById(id);
	}
	
	@RequestMapping(value = "/valid")
	@ResponseBody
	public Admin valid(@RequestBody Admin task) {
		Admin u=adminService.sameUser(task.getLoginName());
		return u;
	}

}
