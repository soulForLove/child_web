package com.lzt.asyn.back.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.model.History;
import com.lzt.asyn.sysmgr.model.Report;
import com.lzt.asyn.sysmgr.model.User;
import com.lzt.asyn.sysmgr.service.HistoryService;
import com.lzt.asyn.sysmgr.service.ReportService;
import com.lzt.asyn.sysmgr.service.UserService;

@Controller
@RequestMapping("/Webuser")
public class WebUserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private ReportService reportService;

	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public User login(@RequestBody User u,HttpServletRequest request) {//取User对象
		User user=userService.login(u.getLoginName(), u.getPassword());
		HttpSession session = request.getSession();
		session.setAttribute("loginuser", user);
		return user;
	}
	
	@RequestMapping(value = "/saveOrUpdateUser")
	@ResponseBody
	public void saveOrUpdate(@RequestBody User task,HttpServletRequest request) {
		userService.saveOrUpdate(task);
		User user=userService.login(task.getLoginName(), task.getPassword());
		HttpSession session = request.getSession();
		session.removeAttribute("loginuser");
		session.setAttribute("loginuser", user);
	}
	@RequestMapping(value = "/valid")
	@ResponseBody
	public User valid(@RequestBody User task) {
		User u=userService.sameUser(task.getLoginName());
		return u;
	}
	
	
	@RequestMapping(value="/logout",method = RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginuser");
	}
	
	@RequestMapping(value="/personalCenter",method = RequestMethod.GET)
	public String personalCenter(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u=(User)session.getAttribute("loginuser");
		if(u!=null){
			return "website/personalCenter";
		}else{
			return "redirect:/Webindex";
		}
		
	}
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register() {
		return "website/register";
	}
	
	@RequestMapping(value="/watch/{id}",method = RequestMethod.GET)
	public String watch(@PathVariable("id") Long id,Model model) {
		History h=new History();
		h.setType(0);//浏览记录
		h.setUserId(id);
		/*h.setPage(1);
		h.setRows(Integer.MAX_VALUE);*/
		PageResult<History> his=historyService.queryPage(h);
		model.addAttribute("watchList",his);
		return "website/watch";
	}
	@RequestMapping(value="/watchPage",method = RequestMethod.POST)
	@ResponseBody
	public  PageResult<History> watchPost(@RequestBody History req,Model model) {
		req.setType(0);
		PageResult<History> his=historyService.queryPage(req);
		return his;
	}
	
	@RequestMapping(value="/discuss/{id}",method = RequestMethod.GET)
	public String discuss(@PathVariable("id") Long id,Model model) {
		History h=new History();
		h.setType(1);//留言记录
		h.setUserId(id);
		/*h.setPage(1);
		h.setRows(Integer.MAX_VALUE);*/
		PageResult<History> his=historyService.queryPage(h);
		model.addAttribute("discussList",his);
		return "website/discuss";
	}
	@RequestMapping(value="/discuss",method = RequestMethod.POST)
	@ResponseBody
	public  PageResult<History> discussPost(@RequestBody History req,Model model) {
		req.setType(1);
		PageResult<History> his=historyService.queryPage(req);
		return his;
	}
	@RequestMapping(value="/report/{id}",method = RequestMethod.GET)
	public String report(@PathVariable("id") Long id,Model model) {
		Report h=new Report();
		h.setUserId(id);
		PageResult<Report> his=reportService.queryPage(h);
		model.addAttribute("reportList",his);
		return "website/report";
	}
	@RequestMapping(value="/reportPage",method = RequestMethod.POST)
	@ResponseBody
	public  PageResult<Report> reportPost(@RequestBody Report req,Model model) {
		PageResult<Report> his=reportService.queryPage(req);
		return his;
	}
	@RequestMapping(value="/updatePwd",method = RequestMethod.GET)
	public String updatePwd() {
		return "website/updatePwd";
	}
	
	@RequestMapping(value="/newsdetail",method = RequestMethod.GET)
	public String newsdetail() {
		return "website/newsdetail";
	}
	
	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	public String getByIdSmBook(@PathVariable("id") Serializable id,Model model) {
		User u= userService.getById(id);
		model.addAttribute("user",u);
		return "website/personalInfo";
	}
	
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	@ResponseBody
	public boolean updatePwd(@RequestParam("passwordOld") String passwordOld, @RequestParam("passwordNew") String passwordNew,HttpServletRequest request) {
		boolean flag = false;
		User u = (User)request.getSession().getAttribute("loginuser");
		if (passwordOld.equals( u.getPassword())) {
			u.setPassword(passwordNew);
			userService.saveOrUpdate(u);
			User user=userService.login(u.getLoginName(), u.getPassword());
			HttpSession session = request.getSession();
			session.removeAttribute("loginuser");
			session.setAttribute("loginuser", user);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
}
