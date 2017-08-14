package com.lzt.asyn.sysmgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.dao.CommonDao;
import com.lzt.asyn.common.model.FsFileInfo;
import com.lzt.asyn.common.model.PageResult;
import com.lzt.asyn.common.utils.Constants;
import com.lzt.asyn.sysmgr.dao.NewsDao;
import com.lzt.asyn.sysmgr.model.News;
import com.lzt.asyn.sysmgr.model.User;

@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;
	@Autowired
	private CommonDao commonDao;

	public void saveOrUpdate(News param) {
		if (param.getNewsId() == null) {
			insert(param);
		} else {
			update(param);
			//commonDao.deleteFsFile(Constants.FILE_TYPE_NEWS, param.getNewsId());
		}	
		/*if (param.getImgUrlList() != null) {
			for (String path : param.getImgUrlList()) {
				FsFileInfo paramFile = new FsFileInfo(path, param.getNewsId(),
						Constants.FILE_TYPE_NEWS);
				commonDao.insertFsFile(paramFile);
			}
		}*/
	}
	
	public List<News> query() {
		return newsDao.query();
	}
	

	public void insert(News param) {
		newsDao.insert(param);
	}

	public void delete(Serializable id) {
		newsDao.delete(id);
	}

	public void update(News param) {
		newsDao.update(param);
	}

	public News getById(Serializable id) {
		News obj = newsDao.getById(id);
		/*if (obj != null) {
			List<FsFileInfo> fileList = commonDao.queryFsFile(Constants.FILE_TYPE_NEWS, id);
			List<String> imgUrlList = new ArrayList<String>();
			for (FsFileInfo s : fileList)
				imgUrlList.add(s.getUri());
			obj.setImgUrlList(imgUrlList);
		}*/
		return obj;
	}

	public List<News> queryByArgs(News param) {
		List<News> list = newsDao.queryByArgs(param);
		return list;
	}

	public long queryByArgsCount(News param) {
		return newsDao.queryByArgsCount(param);
	}

	public PageResult<News> queryPage(News req) {
		long count = newsDao.queryByArgsCount(req);
		List<News> list = count > 0 ? newsDao.queryByArgs(req)
				: new ArrayList<News>();
		return new PageResult<News>(count, list);
	}

}
