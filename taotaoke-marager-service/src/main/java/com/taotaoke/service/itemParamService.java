package com.taotaoke.service;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.pojo.TbItemParam;

public interface itemParamService {

	public DataResult finditemParamAndPage(int page, int rows);

	
	public TaotaoResult getitemParamById(Long catId);
	
	public TaotaoResult createItemParent(TbItemParam itemParam);
	
	/**
	 * 添加规格参数
	 * @param itemId
	 * @param itemParam
	 * @return
	 */
	public TaotaoResult insertItemParamItem(Long itemId, String itemParam);
}
