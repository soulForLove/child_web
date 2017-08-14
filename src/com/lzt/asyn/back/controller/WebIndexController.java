package com.lzt.asyn.back.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.service.AdminService;
import com.lzt.asyn.sysmgr.service.BookService;
import com.lzt.asyn.sysmgr.service.NewsService;
import com.lzt.asyn.sysmgr.service.UserService;

@Controller
@RequestMapping("/Webindex")
public class WebIndexController extends BaseController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	//前台首页资讯循环列表
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		News n1=new News();
		News n2=new News();
		News n3=new News();
		News n4=new News();
		News n5=new News();
		News n6=new News();
		n1.setNewstype(1);n1.setPage(1);n1.setRows(Integer.MAX_VALUE);n1.setAudit(1);
		n2.setNewstype(2);n2.setPage(1);n2.setRows(Integer.MAX_VALUE);n2.setAudit(1);
		n3.setNewstype(3);n3.setPage(1);n3.setRows(Integer.MAX_VALUE);n3.setAudit(1);
		n4.setNewstype(4);n4.setPage(1);n4.setRows(Integer.MAX_VALUE);n4.setAudit(1);
		n5.setNewstype(5);n5.setPage(1);n5.setRows(Integer.MAX_VALUE);n5.setAudit(1);
		n6.setNewstype(6);n6.setPage(1);n6.setRows(Integer.MAX_VALUE);n6.setAudit(1);
		List<News> newslist1=newsService.queryByArgs(n1);
		List<News> newslist2=newsService.queryByArgs(n2);
		List<News> newslist3=newsService.queryByArgs(n3);
		List<News> newslist4=newsService.queryByArgs(n4);
		List<News> newslist5=newsService.queryByArgs(n5);
		List<News> newslist6=newsService.queryByArgs(n6);
		Collections.reverse(newslist1);
		Collections.reverse(newslist2);
		Collections.reverse(newslist3);
		Collections.reverse(newslist4);
		Collections.reverse(newslist5);
		Collections.reverse(newslist6);
		model.addAttribute("newslist1", newslist1);
		model.addAttribute("newslist2", newslist2);
		model.addAttribute("newslist3", newslist3);
		model.addAttribute("newslist4", newslist4);
		model.addAttribute("newslist5", newslist5);
		model.addAttribute("newslist6", newslist6);
		return "website/index";
	}

	

}
