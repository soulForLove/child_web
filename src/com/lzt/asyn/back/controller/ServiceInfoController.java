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
import com.lzt.asyn.sysmgr.model.ServiceInfo;
import com.lzt.asyn.sysmgr.service.ServiceInfoService;
import com.wp.stone.common.utils.CommonUtils;

@Controller
@RequestMapping("/serviceInfo")
public class ServiceInfoController extends BaseController {

	@Autowired
	private ServiceInfoService serviceInfoService;

	@RequestMapping(value = "/saveOrUpdateServiceInfo", method = RequestMethod.POST)
	@ResponseBody
	public void saveOrUpdate(HttpServletRequest req,HttpServletResponse resp,@RequestBody ServiceInfo task) {
		task.setIp(CommonUtils.getIpAddr(req));
		serviceInfoService.saveOrUpdate(task);
	}

	@RequestMapping(value = "/pageQueryServiceInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<ServiceInfo> pageQuerySmServiceInfo(
			@RequestBody ServiceInfo req) {
		return serviceInfoService.queryPage(req);
	}
	
	@RequestMapping(value = "/deleteServiceInfo/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmServiceInfo(@PathVariable("id") Serializable id) {
		serviceInfoService.delete(id);
		
	}

	@RequestMapping(value = "/getServiceInfoById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ServiceInfo getByIdServiceInfo(@PathVariable("id") Serializable id) {
		return serviceInfoService.getById(id);
		
	}

}
