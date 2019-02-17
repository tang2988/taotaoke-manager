package com.taotaoke.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.common.pojo.TreeResult;
import com.taotaoke.service.contentCategoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	
	@Resource
	contentCategoryService categoryService;
	
	
	@RequestMapping(value="/list")
	@ResponseBody
	public List<TreeResult> getContentCateList(@RequestParam(value="id",defaultValue="0") Long parseId){
	
		 List<TreeResult> results = categoryService.getContentCategoryListByParentId(parseId);
		return results;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId,String name){
		 TaotaoResult result = categoryService.createContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult contentCateUpdate(Long id,String name){
		 TaotaoResult result = categoryService.ContentCateModefit(id, name);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult contentCatedelete(Long id){
		 TaotaoResult result = categoryService.contentCateDelete(id);
		return result;
	}

}
