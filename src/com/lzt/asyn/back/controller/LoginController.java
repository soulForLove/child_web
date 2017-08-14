/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.lzt.asyn.back.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lzt.asyn.common.servlet.ValidateCodeServlet;
import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.model.SuperAdmin;
import com.lzt.asyn.sysmgr.service.AdminService;
import com.lzt.asyn.sysmgr.service.SuperAdminService;


@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SuperAdminService sAdminService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(Model model,String name, String password,String validateCode,Integer identity,HttpServletRequest request) {
		//判断管理员登录或者是超级管理员登录！！！且进入的界面不同！！！
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
		if(identity==0){//管理员
			Admin a = adminService.login(name, adminService.entryptPassword(password));
			if (name==null){
				request.setAttribute("error", "请输入登录名！");
			}else if (password==null){
				request.setAttribute("error", "请输入密码！");
			}else if (validateCode==null){
				request.setAttribute("error", "请输入验证码！");
			}else if (a != null&&validateCode.toUpperCase().equals(code)) {
				session.setAttribute("loginadmin", a);
				return "redirect:/index";
			}else if(a==null){
				request.setAttribute("error", "账户或密码错误！");
				return "sysmgr/login";
			}else if (!validateCode.toUpperCase().equals(code)){
				request.setAttribute("error", "验证码错误！");
			}
			return "sysmgr/login";
		}else{//超管
			SuperAdmin a = sAdminService.login(name, sAdminService.entryptPassword(password));
			if (name==null){
				request.setAttribute("error", "请输入登录名！");
			}else if (password==null){
				request.setAttribute("error", "请输入密码！");
			}else if (validateCode==null){
				request.setAttribute("error", "请输入验证码！");
			}else if (a != null&&validateCode.toUpperCase().equals(code)) {
				session.setAttribute("loginSAdmin", a);
				return "redirect:/Sindex";
			}else if(a==null){
				request.setAttribute("error", "账户或密码错误！");
				return "sysmgr/login";
			}else if (!validateCode.toUpperCase().equals(code)){
				request.setAttribute("error", "验证码错误！");
			}
			return "sysmgr/login";
		}
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("loginadmin");
		request.getSession().removeAttribute("loginSadmin");
		return "sysmgr/login";

	}

}
