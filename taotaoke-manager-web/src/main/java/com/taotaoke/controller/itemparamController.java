package com.taotaoke.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.service.itemParamService;

@Controller
@RequestMapping(value="/item/param/")
public class itemparamController {

	
	@Resource
	itemParamService itemparamservice;
	
	@RequestMapping("list")
	@ResponseBody
	public DataResult finditemParam(Integer page ,Integer rows){
		 DataResult dataResult = itemparamservice.finditemParamAndPage(page, rows);
		return dataResult;
	}
}
