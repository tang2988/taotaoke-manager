package com.taotaoke.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.pojo.TbItem;
import com.taotaoke.service.itemService;

@Controller
public class itemController {
	
	@Resource
	itemService itemService;
	
	@RequestMapping("/item/{itemid}")
	@ResponseBody
	public TbItem rejson(@PathVariable Long  itemid){
		TbItem item = itemService.selecById(itemid);
		return item;
	}

}
