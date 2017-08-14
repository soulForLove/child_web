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
import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.model.Report;
import com.lzt.asyn.sysmgr.service.HistoryService;
import com.lzt.asyn.sysmgr.service.NewsService;
import com.lzt.asyn.sysmgr.service.ReportService;
import com.lzt.asyn.sysmgr.service.UserService;
import com.wp.stone.common.utils.CommonUtils;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {

	@Autowired
	private ReportService reportService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private HistoryService historyService;
	
	@RequestMapping(value = "/saveOrUpdateReport", method = RequestMethod.POST)
	@ResponseBody	
	public void saveOrUpdate(HttpServletRequest req,HttpServletResponse resp,@RequestBody Report task) {
		task.setIp(CommonUtils.getIpAddr(req));
		reportService.saveOrUpdate(task);
		//判断举报用户数并进行操作
		News n=newsService.getById(task.getNewsId());
		Report r=new Report();
		r.setNewsId(task.getNewsId());
		Long i=reportService.queryByUserCount(r);
		if(i>3){//当这条资讯的被不同的用户举报超限的时候，将审核audit设置为未通过
			n.setAudit(3);
			newsService.saveOrUpdate(n);
		}
	}

	@RequestMapping(value = "/pageQueryReport", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<Report> pageQuerySmReport(@RequestBody Report req,Model model) {
		return reportService.queryPage(req);
	}

	@RequestMapping(value = "/deleteReport/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmReport(@PathVariable("id") Serializable id) {
		reportService.delete(id);
	}

	@RequestMapping(value = "/getReportById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Report getByIdReport(@PathVariable("id") Serializable id) {
		return reportService.getById(id);
	}

}
