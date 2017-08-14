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
import com.lzt.asyn.sysmgr.model.Book;
import com.lzt.asyn.sysmgr.service.AdverService;
import com.lzt.asyn.sysmgr.service.BookService;

@Controller
@RequestMapping("/book")//图书控制类
public class BookController extends BaseController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AdverService adverService;

	@RequestMapping(value = "/saveOrUpdateBook")
	@ResponseBody
	public void saveOrUpdate(@RequestBody Book task) {
		bookService.saveOrUpdate(task);
	}

	@RequestMapping(value = "/pageQueryBook", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<Book> pageQuerySmBook(@RequestBody Book req) {
		return bookService.queryPage(req);
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmBook(@PathVariable("id") Serializable id) {
		bookService.delete(id);
		//删除相对应的广告信息
		adverService.deleteByBookId(id);
	}

	@RequestMapping(value = "/getBookById/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Book getByIdSmBook(@PathVariable("id") Serializable id) {
		return bookService.getById(id);
	}

}
