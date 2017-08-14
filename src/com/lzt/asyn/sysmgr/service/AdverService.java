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
import com.lzt.asyn.sysmgr.dao.AdverDao;
import com.lzt.asyn.sysmgr.dao.BookDao;
import com.lzt.asyn.sysmgr.model.Adver;

@Service
public class AdverService {

	@Autowired
	private AdverDao adverDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private CommonDao commonDao;

	public void saveOrUpdate(Adver param) {
		if (param.getAdverId() == null) {
			insert(param);
		} else {
			update(param);
			commonDao.deleteFsFile(Constants.FILE_TYPE_ADVER, param.getAdverId());
		}	
		if (param.getImgUrlList() != null) {
			for (String path : param.getImgUrlList()) {
				FsFileInfo paramFile = new FsFileInfo(path, param.getAdverId(),
						Constants.FILE_TYPE_ADVER);
				commonDao.insertFsFile(paramFile);
			}
		}
	}

	public void insert(Adver param) {
		adverDao.insert(param);
	}
	public List<Adver> query() {
		return adverDao.query();
	}
	public void delete(Serializable id) {
		adverDao.delete(id);
	}

	public void deleteByBookId(Serializable id) {
		adverDao.deleteByBookId(id);
	}
	
	public void update(Adver param) {
		adverDao.update(param);
	}

	public Adver getById(Serializable id) {
		Adver obj = adverDao.getById(id);
		if (obj != null) {
			List<FsFileInfo> fileList = commonDao.queryFsFile(Constants.FILE_TYPE_ADVER, id);
			List<String> imgUrlList = new ArrayList<String>();
			for (FsFileInfo s : fileList)
				imgUrlList.add(s.getUri());
			obj.setImgUrlList(imgUrlList);
		}
		return obj;
	}

	public List<Adver> queryByArgs(Adver param) {
		List<Adver> list = adverDao.queryByArgs(param);
		return list;
	}

	public long queryByArgsCount(Adver param) {
		return adverDao.queryByArgsCount(param);
	}

	public PageResult<Adver> queryPage(Adver req) {
		long count = adverDao.queryByArgsCount(req);
		List<Adver> list = count > 0 ? adverDao.queryByArgs(req)
				: new ArrayList<Adver>();
		return new PageResult<Adver>(count, list);
	}

}
