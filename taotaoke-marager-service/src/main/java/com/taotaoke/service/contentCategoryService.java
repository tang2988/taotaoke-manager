package com.taotaoke.service;

import java.util.List;

import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.common.pojo.TreeResult;

public interface contentCategoryService {
	
	
	List<TreeResult> getContentCategoryListByParentId(Long ParentId);
	
	TaotaoResult createContentCategory(Long parentId,String name);
	
	 TaotaoResult ContentCateModefit(Long Id,String name);
	 
	 TaotaoResult contentCateDelete(Long Id);
}
