package com.lzt.asyn.back.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.common.model.ZTreeNode;
import com.lzt.asyn.sysmgr.dao.SmResourceDao;
import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.model.Book;
import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.model.SmResource;
import com.lzt.asyn.sysmgr.model.User;
import com.lzt.asyn.sysmgr.service.AdminService;
import com.lzt.asyn.sysmgr.service.BookService;
import com.lzt.asyn.sysmgr.service.NewsService;
import com.lzt.asyn.sysmgr.service.UserService;
import com.wp.stone.common.annotation.MethodInfo;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
	@Autowired
	private SmResourceDao smResourceDao;
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<SmResource> list = smResourceDao.queryAll();
		List<ZTreeNode> menuList = new ArrayList<ZTreeNode>();
		for (SmResource s : list) {
			if (s.getResType() == 1)
				menuList.add(new ZTreeNode(
						Long.valueOf(s.getParentRes())/* 父资源 */, Long.valueOf(s
								.getResId())/* 资源标识 */, s.getResName()/* 资源名称 */,
						s.getResTarget()/* 目标地址 */, s.getIconSmall()/* 小图标地址 */));
		}
		List<ZTreeNode> nodeList = wrapZtreeNode(menuList);
		model.addAttribute("menuList", jsonMapper.toJson(nodeList));
		return "sysmgr/index";
	}

	// 将treeNode封装为级联关系对象
	private List<ZTreeNode> wrapZtreeNode(List<ZTreeNode> list) {
		List<ZTreeNode> listRet = new ArrayList<ZTreeNode>();
		for (ZTreeNode node1 : list) {
			boolean mark = false;
			for (ZTreeNode node2 : list) {
				if (node1.getPid() != null
						&& node1.getPid().equals(node2.getId())) {
					mark = true;
					if (node2.getChildren() == null) {
						node2.setParent(true);
						node2.setChildren(new ArrayList<ZTreeNode>());
					}
					node2.getChildren().add(node1);
					break;
				}
			}
			if (!mark) {
				listRet.add(node1);
			}
		}
		return listRet;
	}

	@RequestMapping(value = "/userMgr", method = RequestMethod.GET)
	public String smUserMgr(Model model) {
		return "sysmgr/userMgr";
	}

	@RequestMapping(value = "/sysEdit", method = RequestMethod.GET)
	public String sysEdit(Model model) {
		return "task/sysEdit";
	}

	@RequestMapping(value = "/reportMgr", method = RequestMethod.GET)
	public String reportMgr(Model model) {
		return "sysmgr/reportMgr";
	}
	
	
	@RequestMapping(value = "/newsMgr", method = RequestMethod.GET)
	public String newsMgr(Model model) {
		return "sysmgr/newsMgr";
	}
	@RequestMapping(value = "/historyMgr", method = RequestMethod.GET)
	public String historyMgr(Model model) {
		List<News> newslist = newsService.query();
		List<User> userlist = userService.query();
		model.addAttribute("userlist", userlist);
		model.addAttribute("newslist", newslist);
		return "sysmgr/historyMgr";
	}
	
	
	@RequestMapping(value = "/discussMgr", method = RequestMethod.GET)
	public String discussMgr(Model model) {
		List<News> newslist = newsService.query();
		List<User> userlist = userService.query();
		model.addAttribute("userlist", userlist);
		model.addAttribute("newslist", newslist);
		return "sysmgr/discussMgr";
	}
	
	
	@RequestMapping(value = "/bookMgr", method = RequestMethod.GET)
	public String bookMgr(Model model) {
		return "sysmgr/bookMgr";
	}

	@RequestMapping(value = "/serviceMgr", method = RequestMethod.GET)
	public String serviceMgr(Model model) {
		List<User> userlist = userService.query();
		model.addAttribute("userlist", userlist);
		return "sysmgr/serviceMgr";
	}

	@RequestMapping(value = "/adverMgr", method = RequestMethod.GET)
	public String adverMgr(Model model) {
		List<Book> booklist = bookService.query();
		model.addAttribute("booklist", booklist);
		return "sysmgr/adverMgr";
	}
	
	@RequestMapping(value = "/imgMgr", method = RequestMethod.GET)
	public String imgMgr(Model model) {
		return "example/uploadImg";
	}

	@RequestMapping(value = "/ckMgr", method = RequestMethod.GET)
	public String ckMgr(Model model) {
		return "example/ckeditor";
	}
	
	@MethodInfo(description = "跳转到修改个人信息界面")
	@RequestMapping(value = "/updateInfoFace", method = RequestMethod.GET)
	public String updateInfoFace() {
		return "sysmgr/personalInfo";
	}
	
	@MethodInfo(description = "跳转到修改密码界面")
	@RequestMapping(value = "/updatePwdFace", method = RequestMethod.GET)
	public String updatePwdFace() {
		return "sysmgr/updatePwd";
	}

	@MethodInfo(description = "修改密码")
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	@ResponseBody
	public boolean updatePwd(@RequestParam("passwordOld") String passwordOld,
			@RequestParam("passwordNew") String passwordNew,HttpServletRequest request){
		boolean flag=false;
		Admin a=(Admin)request.getSession().getAttribute("loginadmin");
		if (adminService.validatePassword(passwordOld, a.getPassword())) {
			a.setPassword(adminService.entryptPassword(passwordNew));
			adminService.saveOrUpdate(a);
			if(a.getAdminId()!=null){
				Admin admin=adminService.getById(a.getAdminId());
				HttpSession session = request.getSession();
				session.removeAttribute("loginadmin");
				session.setAttribute("loginadmin", admin);
			}
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
}
