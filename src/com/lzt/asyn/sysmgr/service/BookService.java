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
import com.lzt.asyn.sysmgr.dao.BookDao;
import com.lzt.asyn.sysmgr.model.Book;
import com.lzt.asyn.sysmgr.model.User;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private CommonDao commonDao;

	public void saveOrUpdate(Book param) {
		if (param.getBookId() == null) {
			insert(param);
		} else {
			update(param);
			commonDao.deleteFsFile(Constants.FILE_TYPE_BOOK, param.getBookId());
		}	
		if (param.getImgUrlList() != null) {
			for (String path : param.getImgUrlList()) {
				FsFileInfo paramFile = new FsFileInfo(path, param.getBookId(),
						Constants.FILE_TYPE_BOOK);
				commonDao.insertFsFile(paramFile);
			}
		}
	}

	public void insert(Book param) {
		bookDao.insert(param);
	}

	public void delete(Serializable id) {
		bookDao.delete(id);
	}
	public List<Book> query() {
		return bookDao.query();
	}
	public void update(Book param) {
		bookDao.update(param);
	}

	public Book getById(Serializable id) {
		Book obj = bookDao.getById(id);
		if (obj != null) {
			List<FsFileInfo> fileList = commonDao.queryFsFile(Constants.FILE_TYPE_BOOK, id);
			List<String> imgUrlList = new ArrayList<String>();
			for (FsFileInfo s : fileList)
				imgUrlList.add(s.getUri());
			obj.setImgUrlList(imgUrlList);
		}
		return obj;
	}

	public List<Book> queryByArgs(Book param) {
		List<Book> list = bookDao.queryByArgs(param);
		return list;
	}

	public long queryByArgsCount(Book param) {
		return bookDao.queryByArgsCount(param);
	}

	public PageResult<Book> queryPage(Book req) {
		long count = bookDao.queryByArgsCount(req);
		List<Book> list = count > 0 ? bookDao.queryByArgs(req)
				: new ArrayList<Book>();
		return new PageResult<Book>(count, list);
	}

}
