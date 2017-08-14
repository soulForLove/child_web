package com.lzt.asyn.back.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.sysmgr.model.Adver;
import com.lzt.asyn.sysmgr.model.Discuss;
import com.lzt.asyn.sysmgr.model.History;
import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.model.User;
import com.lzt.asyn.sysmgr.service.AdverService;
import com.lzt.asyn.sysmgr.service.BookService;
import com.lzt.asyn.sysmgr.service.DiscussService;
import com.lzt.asyn.sysmgr.service.HistoryService;
import com.lzt.asyn.sysmgr.service.NewsService;
import com.wp.stone.common.utils.CommonUtils;

@Controller
@RequestMapping("/Webnews")
public class WebNewsController {

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private DiscussService discussService;
	
	@Autowired
	private HistoryService historyService;
	@Autowired
	private AdverService adverService;
	@Autowired
	private BookService bookService;
	//添加或者保存资讯信息
	@RequestMapping(value = "/saveOrUpdateNews", method = RequestMethod.POST)
	@ResponseBody
	public void saveOrUpdate( @RequestBody News req) {
		newsService.saveOrUpdate(req);
	}
	//根据资讯类别查询资讯列表
	@RequestMapping(value = "/pageQueryNews/{newsType}", method = RequestMethod.GET)
	public String pageQuerySmNews(@PathVariable("newsType")Integer newsType,Model model) {
		
		News req = new News();
		req.setNewstype(newsType);
		req.setAudit(1);
		PageResult<News> resp = newsService.queryPage(req);
		//Collections.reverse(resp.getRows());//反向
		model.addAttribute("detailByList",resp);
		model.addAttribute("Type",newsType);
		String newstype=null;
		if(newsType==1){
			newstype="教育资讯";
		}else if(newsType==2){
			newstype="活动资讯";
		}else if(newsType==3){
			newstype="体育资讯";
		}else if(newsType==4){
			newstype="营养资讯";
		}else if(newsType==5){
			newstype="阅读资讯";
		}else if(newsType==6){
			newstype="热点资讯";
		}
		model.addAttribute("type",newstype);
		return "website/detailsByList";
	}
	//查询资讯列表
	@RequestMapping(value = "/pageQueryNews", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<News> pageQuerySmNews(@RequestBody News req,Model model) {
		model.addAttribute("ListType",req.getNewstype());
		req.setAudit(1);
		return  newsService.queryPage(req);
		
	}
	//根据id删除资讯
	@RequestMapping(value = "/deleteNews/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteSmNews(@PathVariable("id") Serializable id) {
		newsService.delete(id);
	}
	//根据类别以及id返回资讯详细
	@RequestMapping(value = "/newsDetail/{newsType}/{newsId}", method = RequestMethod.GET)
	public String toNewsDetailPage(@PathVariable("newsType")Integer newsType,@PathVariable("newsId")Long newsId,Model model,HttpServletRequest request){
		User u=(User)request.getSession().getAttribute("loginuser");
		if(u!=null){//如果用户存在，则添加历史记录
			History h=new History();
			h.setNewsId(newsId);
			h.setUserId(u.getUserId());
			h.setLoginIp(CommonUtils.getIpAddr(request));
			h.setType(0);
			historyService.insert(h);
		}
		
		//返回评论留言信息
		Discuss d=new Discuss();
		d.setNewsId(newsId);
		d.setPage(1);
		d.setRows(Integer.MAX_VALUE);
		d.setAudit(1);
		List<Discuss> dis=discussService.queryByArgs(d);
		Collections.reverse(dis);
		model.addAttribute("discusslist", dis);
		model.addAttribute("newsType",newsType);
		if(newsId!=0){
			model.addAttribute("newsId",newsId);
		}
		
		//返回广告信息
		Adver a=new Adver();
		a.setAudit(1);
		List<Adver> list=adverService.queryByArgs(a);
		List<Adver> adverList=new ArrayList<Adver>();
		Adver b=null;
		for(int i=0;i<list.size();i++){
			b=adverService.getById(list.get(i).getAdverId());
			adverList.add(b);
		}
		Collections.reverse(adverList);
		model.addAttribute("adverList",adverList);
		return "website/newsdetail";//取得图片地址并且返回到详细页
	}
	//根据id获取某条资讯
	@RequestMapping(value = "/getNewsById/{newsId}", method = RequestMethod.GET)
	public String  getByIdNews(@PathVariable("newsId") Long newsId,Model model,HttpServletRequest request) {
		User u=(User)request.getSession().getAttribute("loginuser");
		if(u!=null){
			History h=new History();
			h.setNewsId(newsId);
			h.setUserId(u.getUserId());
			h.setLoginIp(CommonUtils.getIpAddr(request));
			h.setType(0);
			historyService.insert(h);
		}
		News news=newsService.getById(newsId);
		String newstype=null;
		if(news.getNewstype()==1){
			newstype="教育资讯";
		}else if(news.getNewstype()==2){
			newstype="活动资讯";
		}else if(news.getNewstype()==3){
			newstype="体育资讯";
		}else if(news.getNewstype()==4){
			newstype="营养资讯";
		}else if(news.getNewstype()==5){
			newstype="阅读资讯";
		}else if(news.getNewstype()==6){
			newstype="热点资讯";
		}
		model.addAttribute("news", news);
		model.addAttribute("newstype",newstype);
		Discuss d=new Discuss();
		d.setNewsId(newsId);
		d.setPage(1);
		d.setRows(Integer.MAX_VALUE);
		d.setAudit(1);
		List<Discuss> dis=discussService.queryByArgs(d);
		Collections.reverse(dis);
		model.addAttribute("discusslist", dis);
		return "website/detailsByOne";
	}
	//获取搜索关键词
	@RequestMapping(value = "/queryKeyWord", method = RequestMethod.POST)
	public String queryKeyWord(Model model,HttpServletRequest req) {
		String keyWord=(String)req.getParameter("keyWord");
		req.getSession().removeAttribute("keyWord");
		req.getSession().setAttribute("keyWord", keyWord);
		return "website/searchWeb";
	}
	//根据搜索详情返回结果列表
	@RequestMapping(value = "/queryBySearchDetail", method = RequestMethod.GET)
	public String queryBySearchDetail(Model model,HttpServletRequest req) {
		String keyWord=(String)req.getSession().getAttribute("keyWord");
		News n=new News();
		n.setTitle(keyWord);
		n.setAudit(1);
		PageResult<News> pageResult=newsService.queryPage(n);
		model.addAttribute("searchResult",pageResult);
		return "website/searchDetail";
	}
	
	

}
