
package com.lzt.asyn.common.dao;
import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lzt.asyn.common.model.DictDef;
import com.lzt.asyn.common.model.FsFileInfo;

@Repository
public interface CommonDao {


	/**
	 * 数据字典
	 */
	public List<DictDef> queryDictList(@Param("dictType") Integer dictType, @Param("dictClass") Integer dictClass, @Param("parentEntryId") String parentEntryId);

	/**
	 * 附件操作
	 */
	public void insertFsFile(FsFileInfo param);

	public void deleteFsFile(@Param("bizType") Integer bizType, @Param("bizId") Serializable bizId);

	public List<FsFileInfo> queryFsFile(@Param("bizType") Integer bizType, @Param("bizId") Serializable bizId);

}
