
package com.lzt.asyn.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lzt.asyn.common.dao.CommonDao;
import com.lzt.asyn.common.model.DictDef;
@Component
public class DictDefUtils {

	protected static Logger logger = LoggerFactory.getLogger(DictDefUtils.class);

	private static Map<String, Map<String, String>> _dictMap = new HashMap<String, Map<String, String>>();//数据字典 dictType-dictClass -> (entryId -> entryName)

	private static CommonDao commonDao;
	@Autowired(required = true)
	public void setDictDefDao(CommonDao dictDefDao) {
		DictDefUtils.commonDao = dictDefDao;
	}

	public static String getEntryName(Integer dictType, Integer dictClass, String entryId) {
		String entryName = "未知";
		if (StringUtils.isNotBlank(entryId) && !"null".equals(entryId)) {
			String key = dictType + "-" + dictClass;
			Map<String, String> map = null;
			if (_dictMap.containsKey(key)) {
				map = _dictMap.get(key);
			} else {
				List<DictDef> list = commonDao.queryDictList(dictType, dictClass, null);
				if (list != null && list.size() > 0) {
					map = new HashMap<String, String>();
					for (DictDef s : list)
						map.put(s.getEntryId(), s.getEntryName());
					_dictMap.put(key, map);
				} else {
					logger.warn("尚未配置数据字典dictType:" + dictType + ",dictClass:" + dictClass);
				}
			}
			if (map != null && map.containsKey(entryId))
				entryName = map.get(entryId);
		}
		return entryName;
	}
	
	public static String getEntryDesc(Integer dictType, Integer dictClass, String entryId){
		String entryDesc = "未知";
		if (StringUtils.isNotBlank(entryId) && !"null".equals(entryId)) {
			String key = dictType + "+" + dictClass;//这边的用+，以区别上面的-
			Map<String, String> map = null;
			if (_dictMap.containsKey(key)) {
				map = _dictMap.get(key);
			} else {
				List<DictDef> list = commonDao.queryDictList(dictType, dictClass, null);
				if (list != null && list.size() > 0) {
					map = new HashMap<String, String>();
					for (DictDef s : list)
						map.put(s.getEntryId(), s.getEntryDesc());
					_dictMap.put(key, map);
				} else {
					logger.warn("尚未配置数据字典dictType:" + dictType + ",dictClass:" + dictClass);
				}
			}
			if (map != null && map.containsKey(entryId))
				entryDesc = map.get(entryId);
		}
		return entryDesc;
	}

	/**
	 * 业务代码 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	 */
	
	public static String getProvince(Integer entryId) {
		return getEntryName(1002, 101, String.valueOf(entryId));// 省
	}

	public static String getCity(Integer entryId) {
		return getEntryName(1002, 102, String.valueOf(entryId));// 市
	}

	public static String getCounty(Integer entryId) {
		return getEntryName(1002, 103, String.valueOf(entryId));// 县
	}

	public static String getUserStatus(Integer entryId){//用户状态
		return getEntryName(1001, 101, String.valueOf(entryId));
	}
	

}
