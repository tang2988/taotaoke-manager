package com.taotaoke.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.mapper.TbContentMapper;
import com.taotaoke.pojo.TbContent;
import com.taotaoke.pojo.TbContentExample;
import com.taotaoke.pojo.TbContentExample.Criteria;
import com.taotaoke.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Resource
	TbContentMapper contentMapper;
	
	public DataResult getContentListAndPageByCategoryId(int page,int rows,Long CategoryId){
		//创建查询条件;
		
		TbContentExample example = new TbContentExample();
		 Criteria criteria = example.createCriteria();
		 criteria.andCategoryIdEqualTo(CategoryId);
		 //设置分页 第一个参数 当前页  第二个参数 一页显示多少条
		 PageHelper.startPage(page, rows);
		//执行查询 返回结果集 
		 List<TbContent> contentsList = contentMapper.selectByExample(example);
		 DataResult dataResult = new DataResult();
		 PageInfo<TbContent> info = new PageInfo<TbContent>(contentsList);
		 dataResult.setRows(contentsList);
		 dataResult.setTotal(info.getTotal());
		 
		return dataResult;
		
	}

	
	public TaotaoResult CreateContent(TbContent content) {
		content.setUpdated(new Date());
		content.setCreated(new Date());
		contentMapper.insert(content);
		return TaotaoResult.ok();
	}

	public TaotaoResult updateContent(TbContent content) {
		//先根据主键id查询一遍
		 
		 content.setCategoryId(content.getCategoryId());
		 content.setContent(content.getContent());
		 content.setCreated(new Date());
		 content.setId(content.getId());
		 content.setPic(content.getPic());
		 content.setPic2(content.getPic2());
		 content.setSubTitle(content.getSubTitle());
		 content.setTitle(content.getTitle());
		 content.setTitleDesc(content.getTitleDesc());
		 content.setUpdated(new Date());
		 content.setUrl(content.getUrl());
		 contentMapper.updateByPrimaryKey(content);
		return TaotaoResult.ok();
	}

	public TaotaoResult deleteContent(Long id) {
		contentMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}
	
}
