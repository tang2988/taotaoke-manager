package com.taotaoke.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.common.pojo.TreeResult;
import com.taotaoke.mapper.TbContentCategoryMapper;
import com.taotaoke.pojo.TbContentCategory;
import com.taotaoke.pojo.TbContentCategoryExample;
import com.taotaoke.pojo.TbContentCategoryExample.Criteria;
import com.taotaoke.service.contentCategoryService;

@Service
public class contentCategoryServiceImpl implements contentCategoryService {

	@Resource
	TbContentCategoryMapper categoryMapper;

	public List<TreeResult> getContentCategoryListByParentId(Long ParentId) {
		// 创建查询条件
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(ParentId);
		List<TreeResult> treeResults = new ArrayList<TreeResult>();
		// 执行查询 返回结果
		List<TbContentCategory> list = categoryMapper.selectByExample(example);
		for (TbContentCategory contentCategory : list) {
			TreeResult result = new TreeResult();
			result.setId(contentCategory.getId());
			result.setText(contentCategory.getName());
			result.setState(contentCategory.getIsParent()?"closed":"open");
			treeResults.add(result);
		}
		return treeResults;
	}

	/**
	 * 添加内容分類
	 */
	public TaotaoResult createContentCategory(Long parentId, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setCreated(new Date());
		category.setName(name);
		category.setParentId(parentId);
		category.setStatus(1);
		category.setIsParent(false);
		category.setUpdated(new Date());
		category.setSortOrder(1);
		categoryMapper.insert(category);
		//查看父节点isparent是否为true 不是true则设置为true
		 TbContentCategory contentCategory = categoryMapper.selectByPrimaryKey(parentId);
		 if(!contentCategory.getIsParent()){
			 contentCategory.setIsParent(true);
			 categoryMapper.updateByPrimaryKey(contentCategory);
		 }
		return TaotaoResult.ok(category);
	}
	/**
	 * 重命名
	 */
	public TaotaoResult ContentCateModefit(Long Id,String name){
		//根据主键id查询最新内容分类表
		 TbContentCategory category = categoryMapper.selectByPrimaryKey(Id);
		
		TbContentCategory tbContentCategory = new TbContentCategory();
		tbContentCategory.setName(name);
		tbContentCategory.setUpdated(new Date());
		tbContentCategory.setCreated(new Date());
		tbContentCategory.setId(Id);
		tbContentCategory.setSortOrder(category.getSortOrder());
		tbContentCategory.setStatus(category.getSortOrder());
		tbContentCategory.setIsParent(category.getIsParent());
		tbContentCategory.setParentId(category.getParentId());
		categoryMapper.updateByPrimaryKey(tbContentCategory );
		return TaotaoResult.ok();
	}

	public TaotaoResult contentCateDelete(Long Id) {
		categoryMapper.deleteByPrimaryKey(Id);
		return TaotaoResult.ok();
	}

}
