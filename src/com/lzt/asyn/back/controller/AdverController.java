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
import com.lzt.asyn.sysmgr.model.Adver;
import com.lzt.asyn.sysmgr.model.Book;
import com.lzt.asyn.sysmgr.service.AdverService;
import com.lzt.asyn.sysmgr.service.BookService;

@Controller
@RequestMapping("/adver")//广告控制类
public class AdverController extends BaseController {

	@Autowired
	private AdverService adverService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/saveOrUpdateAdver", method = RequestMethod.POST)
	@ResponseBody
	public void saveOrUpdate(@RequestBody Adver task) {
		Long bookId=task.getBookId();
		Book b=bookService.getById(bookId);
		task.setLink(b.getLink());
		task.setImgUrlList(b.getImgUrlList());
		adverService.saveOrUpdate(task);
	}

	@RequestMapping(value = "/pageQueryAdver", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<Adver> pageQuerySmAdver(@RequestBody Adver req) {
		return adverService.queryPage(req);
	}

	@RequestMapping(value = "/deleteAdver/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmAdver(@PathVariable("id") Serializable id) {
		adverService.delete(id);
	}

	@RequestMapping(value = "/getAdverById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Adver getByIdSmAdver(@PathVariable("id") Serializable id) {
		return adverService.getById(id);
	}

	

}
