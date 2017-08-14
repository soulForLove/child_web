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
import com.lzt.asyn.sysmgr.dao.ResourceDao;
import com.lzt.asyn.sysmgr.model.Admin;
import com.lzt.asyn.sysmgr.model.Book;
import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.model.Resource;
import com.lzt.asyn.sysmgr.model.SuperAdmin;
import com.lzt.asyn.sysmgr.model.User;
import com.lzt.asyn.sysmgr.service.BookService;
import com.lzt.asyn.sysmgr.service.NewsService;
import com.lzt.asyn.sysmgr.service.SuperAdminService;
import com.lzt.asyn.sysmgr.service.UserService;
import com.wp.stone.common.annotation.MethodInfo;

@Controller
@RequestMapping("/Sindex")
public class SindexController extends BaseController {
	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private SuperAdminService sAdminService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<Resource> list = resourceDao.queryAll();
		List<ZTreeNode> menuList = new ArrayList<ZTreeNode>();
		for (Resource s : list) {
			if (s.getResType() == 1)
				menuList.add(new ZTreeNode(
						Long.valueOf(s.getParentRes())/* 父资源 */, Long.valueOf(s
								.getResId())/* 资源标识 */, s.getResName()/* 资源名称 */,
						s.getResTarget()/* 目标地址 */, s.getIconSmall()/* 小图标地址 */));
		}
		List<ZTreeNode> nodeList = wrapZtreeNode(menuList);
		model.addAttribute("menuList", jsonMapper.toJson(nodeList));
		return "adminMgr/Sindex";
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
		return "adminMgr/userMgr";
	}

	@RequestMapping(value = "/SnewsMgr", method = RequestMethod.GET)
	public String SnewsMgr(Model model) {
		return "adminMgr/SnewsMgr";
	}
	@RequestMapping(value = "/SdiscussMgr", method = RequestMethod.GET)
	public String SdiscussMgr(Model model) {
		List<News> newslist = newsService.query();
		List<User> userlist = userService.query();
		model.addAttribute("userlist", userlist);
		model.addAttribute("newslist", newslist);
		return "adminMgr/SdiscussMgr";
	}
	@RequestMapping(value = "/SadverMgr", method = RequestMethod.GET)
	public String SadverMgr(Model model) {
		List<Book> booklist = bookService.query();
		model.addAttribute("booklist", booklist);
		return "adminMgr/SadverMgr";
	}
	@RequestMapping(value = "/adminMgr", method = RequestMethod.GET)
	public String organMgr(Model model) {
		return "adminMgr/adminMgr";
	}
	
	@MethodInfo(description = "跳转到修改个人信息界面")
	@RequestMapping(value = "/updateInfoFace", method = RequestMethod.GET)
	public String updateInfoFace() {
		return "adminMgr/personalInfo";
	}

	@MethodInfo(description = "跳转到修改密码界面")
	@RequestMapping(value = "/updatePwdFace", method = RequestMethod.GET)
	public String updatePwdFace() {
		return "adminMgr/updatePwd";
	}

	@MethodInfo(description = "修改密码")
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	@ResponseBody
	public boolean updatePwd(@RequestParam("passwordOld") String passwordOld,
			@RequestParam("passwordNew") String passwordNew,HttpServletRequest request){
		boolean flag=false;
		SuperAdmin a=(SuperAdmin)request.getSession().getAttribute("loginSAdmin");
		if (sAdminService.validatePassword(passwordOld, a.getPassword())) {
			a.setPassword(sAdminService.entryptPassword(passwordNew));
			sAdminService.saveOrUpdate(a);
			if(a.getSuperAdminId()!=null){
				SuperAdmin admin=sAdminService.getById(a.getSuperAdminId());
				HttpSession session = request.getSession();
				session.removeAttribute("loginSAdmin");
				session.setAttribute("loginSAdmin", admin);
			}
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
}
