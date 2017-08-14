package com.lzt.asyn.back.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.model.Discuss;
import com.lzt.asyn.sysmgr.model.History;
import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.model.User;
import com.lzt.asyn.sysmgr.service.DiscussService;
import com.lzt.asyn.sysmgr.service.HistoryService;
import com.lzt.asyn.sysmgr.service.NewsService;
import com.lzt.asyn.sysmgr.service.UserService;
import com.wp.stone.common.utils.CommonUtils;

@Controller
@RequestMapping("/discuss")//留言控制类
public class DiscussController extends BaseController {

	@Autowired
	private DiscussService discussService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private HistoryService historyService;
	
	@RequestMapping(value = "/saveOrUpdateDiscuss", method = RequestMethod.POST)
	@ResponseBody	
	public void saveOrUpdate(HttpServletRequest req,HttpServletResponse resp,@RequestBody Discuss task) {
		task.setIp(CommonUtils.getIpAddr(req));
		Long userId=task.getUserId();
		Long newsId=task.getNewsId();
		User u=userService.getById(userId);
		task.setUserName(u.getUserName());
		News n=newsService.getById(newsId);
		task.setNewstype(n.getNewstype());
		discussService.saveOrUpdate(task);
		
		History h=new History();
		h.setDetail(task.getDetail());
		h.setNewsId(task.getNewsId());
		h.setUserId(task.getUserId());
		h.setLoginIp(CommonUtils.getIpAddr(req));
		h.setType(1);
		historyService.insert(h);
	}
	@RequestMapping(value = "/saveDiscuss", method = RequestMethod.POST)
	@ResponseBody	
	public void save(HttpServletRequest req,HttpServletResponse resp,@RequestBody Discuss task) {
		task.setIp(CommonUtils.getIpAddr(req));
		Long userId=task.getUserId();
		Long newsId=task.getNewsId();
		User u=userService.getById(userId);
		task.setUserName(u.getUserName());
		News n=newsService.getById(newsId);
		task.setNewstype(n.getNewstype());
		discussService.saveOrUpdate(task);
	}
	@RequestMapping(value = "/pageQueryDiscuss", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<Discuss> pageQuerySmDiscuss(@RequestBody Discuss req,Model model) {
		return discussService.queryPage(req);
	}

	@RequestMapping(value = "/deleteDiscuss/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmDiscuss(@PathVariable("id") Serializable id) {
		discussService.delete(id);
	}

	@RequestMapping(value = "/getDiscussById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Discuss getByIdDiscuss(@PathVariable("id") Serializable id) {
		return discussService.getById(id);
	}

}
