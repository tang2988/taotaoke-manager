package com.taotaoke.service;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.pojo.TbItem;

public interface itemService {

	/**
	 * 根据ID查询
	 *谢雄辉
	 *version 1.8
	 *2019年2月1日
	 *@param id
	 *@return
	 */
	public TbItem selecById(Long id);

	/**
	 * 带分页查询
	 *谢雄辉
	 *version 1.8
	 *2019年2月1日
	 *@param page
	 *@param rows
	 *@return
	 */
	public DataResult findByPage(int page, int rows);
	
	
	/**
	 * 添加商品	
	 *谢雄辉	 
	 *version 1.8
	 *2019年2月1日
	 *@param item
	 *@return
	 * @throws Exception 
	 */
	public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
	/**
	 * 编辑商品信息
	 *谢雄辉
	 *version 1.8
	 *2019年2月1日
	 *@param item
	 *@return
	 */
	public TaotaoResult updateItem(TbItem item);
	
	/**
	 * 删除商品
	 *谢雄辉
	 *version 1.8
	 *2019年2月13日
	 *@param id
	 *@return
	 */
	public TaotaoResult delItem(Long id);

}
