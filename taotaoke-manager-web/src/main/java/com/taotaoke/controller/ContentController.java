package com.taotaoke.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.pojo.TbContent;
import com.taotaoke.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Resource
	ContentService contentService;

	@RequestMapping("/query/list")
	@ResponseBody
	public DataResult getContentListPageByCategoryId(Integer page, Integer rows, Long categoryId) {
		DataResult dataResult = contentService.getContentListAndPageByCategoryId(page, rows, categoryId);
		return dataResult;
	}

	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult saveContent(TbContent content) {
		TaotaoResult result = contentService.CreateContent(content);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContent(Long id) {
		TaotaoResult result = contentService.deleteContent(id);
		return result;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult updateContent(TbContent content){
		TaotaoResult result = contentService.updateContent(content);
		return result;
	}
	

}
