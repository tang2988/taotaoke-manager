package com.taotaoke.service;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.pojo.TbContent;

public interface ContentService {
	
	/**
	 * 根据内容分类Id查询 带分页
	 *谢雄辉
	 *version 1.8
	 *2019年2月17日
	 *@param page
	 *@param rows
	 *@param CategoryId
	 *@return
	 */
	DataResult getContentListAndPageByCategoryId(int page,int rows,Long CategoryId);
	
	/**
	 * 添加内容
	 *谢雄辉
	 *version 1.8
	 *2019年2月17日
	 *@param content
	 *@return
	 */
	TaotaoResult CreateContent(TbContent content);
	
	/**
	 * 编辑内容
	 *谢雄辉
	 *version 1.8
	 *2019年2月17日
	 *@param content
	 *@return
	 */
	TaotaoResult updateContent(TbContent content);
	/**
	 * 根據id刪除
	 *谢雄辉
	 *version 1.8
	 *2019年2月17日
	 *@param id
	 *@return
	 */
	TaotaoResult deleteContent(Long id);
}
