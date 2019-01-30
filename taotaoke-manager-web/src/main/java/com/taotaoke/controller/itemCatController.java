package com.taotaoke.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.common.pojo.TreeResult;
import com.taotaoke.service.itemCatService;

/**
 * @version 1.8
 * @author 谢雄辉
 * @data 2019年1月29日
 */
@Controller
@RequestMapping("/item/cat")
public class itemCatController {

	@Resource
	itemCatService catService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<TreeResult> getlist(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		List<TreeResult> treeResults = catService.getItemCatList(parentId);
		return treeResults;
	}

}
