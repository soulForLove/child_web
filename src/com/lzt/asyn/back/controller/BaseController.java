package com.lzt.asyn.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.lzt.asyn.common.utils.JsonMapper;


@Controller
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected JsonMapper jsonMapper  = new JsonMapper();
	
	
	
}
