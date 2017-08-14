package com.lzt.asyn.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzt.asyn.common.dao.CommonDao;
import com.lzt.asyn.common.model.DictDef;
import com.lzt.asyn.common.model.FsFileInfo;
@Service
public class CommonService {
	@Autowired
	private CommonDao commonDao;
	
	public List<DictDef> queryDictList(Integer dictType, Integer dictClass, String parentEntryId){
		return commonDao.queryDictList(dictType, dictClass, parentEntryId);
	}
	

	/**
	 * 附件操作
	 */
	public void insertFsFile(FsFileInfo param) {
		commonDao.insertFsFile(param);
	}

	public void deleteFsFile(@Param("bizType") Integer bizType, @Param("bizId") Long bizId) {
		commonDao.deleteFsFile(bizType, bizId);
	}

	public List<FsFileInfo> queryFsFile(@Param("bizType") Integer bizType, @Param("bizId") Long bizId) {
		return commonDao.queryFsFile(bizType, bizId);
	}

	
}
