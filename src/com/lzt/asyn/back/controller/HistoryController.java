package com.lzt.asyn.back.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.model.History;
import com.lzt.asyn.sysmgr.service.HistoryService;
import com.wp.stone.common.utils.CommonUtils;

@Controller
@RequestMapping("/history")//历史记录控制类
public class HistoryController extends BaseController {

	@Autowired
	private HistoryService historyService;

	@RequestMapping(value = "/pageQueryHistory", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<History> pageQuerySmHistory(@RequestBody History req) {
		return historyService.queryPage(req);
	}

	@RequestMapping(value = "/saveOrUpdateHistory")
	@ResponseBody
	public void saveOrUpdate(@RequestBody History task,HttpServletRequest req,HttpServletResponse resp) {
		task.setLoginIp(CommonUtils.getIpAddr(req));
		historyService.saveOrUpdate(task);
	}

	@RequestMapping(value = "/deleteHistory/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmHistory(@PathVariable("id") Serializable id) {
		historyService.delete(id);
	}

	@RequestMapping(value = "/getHistoryById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public History getByIdSmHistory(@PathVariable("id") Serializable id) {
		return historyService.getById(id);
	}

}
