package com.lzt.asyn.back.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lzt.asyn.common.model.DictDef;
import com.lzt.asyn.common.model.RespInfo;
import com.lzt.asyn.common.service.CommonService;
import com.wp.stone.common.annotation.MethodInfo;
import com.wp.stone.common.annotation.TypeInfo;
import com.wp.stone.common.utils.DateUtil;
import com.wp.stone.common.utils.Identities;

@TypeInfo(module = "通用模块")
@Controller
@RequestMapping("/common")
public class CommonController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier("commonService")
	protected CommonService commonService;

	@MethodInfo(description = "查询数据字典")
	@RequestMapping(value = "/queryDictList", method = RequestMethod.POST)
	@ResponseBody
	public List<DictDef> queryDictList(@RequestBody DictDef req) {
		return commonService.queryDictList(req.getDictType(),
				req.getDictClass(), req.getParentEntryId());
	}

	@MethodInfo(description = "普通图片上传")
	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public RespInfo uploadImg(HttpServletRequest req, HttpServletResponse resp) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		MultipartFile multipartFile = multipartRequest.getFile("upload");
		String dir = req
				.getSession()
				.getServletContext()
				.getRealPath(
						"/upload/" + DateUtil.getCurrentTimeStr("yyyyMMdd"));
		File filePath = new File(dir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		String fileNameOriginal = multipartFile.getOriginalFilename();// 文件原名

		int idx = fileNameOriginal.lastIndexOf(".");
		String fileNameSave = Identities.uuid2()
				+ (idx != -1 ? fileNameOriginal.substring(idx) : "");
		try {
			String mimeType = req.getSession().getServletContext()
					.getMimeType(fileNameOriginal);
			if (mimeType.startsWith("image/")) {
				multipartFile.transferTo(new File(dir + "/"
						+ fileNameSave));
				String fileF = req.getContextPath() + "/upload/"
						+ DateUtil.getCurrentTimeStr("yyyyMMdd")
						+ "/" + fileNameSave;
				return new RespInfo(true, fileF);
			} else {
				return new RespInfo(false, "非图片格式!");
			}
		} catch (Exception e) {
			logger.error("异常", e);
			return new RespInfo(false, "文件上传出错!");
		}
	}

	@MethodInfo(description = "ckeditor图片上传")
	@RequestMapping(value = "/uploadCkEditorImg", method = RequestMethod.POST)
	public void uploadCkEditorImg(HttpServletRequest req,
			HttpServletResponse resp) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		String callback = req.getParameter("CKEditorFuncNum");
		MultipartFile multipartFile = multipartRequest.getFile("upload");
		String dir = req
				.getSession()
				.getServletContext()
				.getRealPath(
						"/upload/" + DateUtil.getCurrentTimeStr("yyyyMMdd"));
		File filePath = new File(dir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		String fileNameOriginal = multipartFile.getOriginalFilename();// 文件原名
		int idx = fileNameOriginal.lastIndexOf(".");
		String fileNameSave = Identities.uuid2()
				+ (idx != -1 ? fileNameOriginal.substring(idx) : "");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			String mimeType = req.getSession().getServletContext().getMimeType(
					fileNameOriginal);
			if (mimeType.startsWith("image/")) {
				multipartFile.transferTo(new File(dir + File.separator
						+ fileNameSave));
				String fileF = req.getContextPath() + "/upload/"
						+ DateUtil.getCurrentTimeStr("yyyyMMdd") + "/"
						+ fileNameSave;
				out.println(wrapJavascript("window.parent.CKEDITOR.tools.callFunction("
						+ callback + ",'" + fileF + "','')"));
			} else {
				out.println(wrapJavascript("window.parent.CKEDITOR.tools.callFunction("
						+ callback + ",''," + "'非图片格式!');"));
			}
		} catch (Exception e) {
			logger.error("异常", e);
			out.println(wrapJavascript("window.parent.CKEDITOR.tools.callFunction("
					+ callback + ",''," + "'文件上传出错!');"));
		}
	}
	private String wrapJavascript(String js) {
		StringBuffer sf = new StringBuffer();
		sf.append("<script type=\"text/javascript\">");
		sf.append(js);
		sf.append("</script>");
		return sf.toString();
	}
}
