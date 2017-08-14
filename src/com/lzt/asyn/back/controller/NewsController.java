package com.lzt.asyn.back.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.service.DiscussService;
import com.lzt.asyn.sysmgr.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private DiscussService disService;
	
	@RequestMapping(value = "/saveOrUpdateNews", method = RequestMethod.POST)
	@ResponseBody
	public void saveOrUpdate( @RequestBody News req) {
		newsService.saveOrUpdate(req);	
	}

	@RequestMapping(value = "/pageQueryNews", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<News> pageQuerySmNews(@RequestBody News req) {
		return newsService.queryPage(req);
	}

	@RequestMapping(value = "/deleteNews/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmNews(@PathVariable("id") Serializable id) {
		newsService.delete(id);
		//级联删除相对应的留言信息
		disService.deleteByNewsId(id);
	}

	@RequestMapping(value = "/getNewsById/{newsId}", method = RequestMethod.POST)
	@ResponseBody
	public News getByIdNews(@PathVariable("newsId") Serializable newsId) {
		return newsService.getById(newsId);
	}


}
