package com.taotaoke.service;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.pojo.TbItem;

public interface itemService {

	public TbItem selecById(Long id);

	public DataResult findByPage(int page, int rows);

	public TaotaoResult createItem(TbItem item);
	
	public TaotaoResult updateItem(TbItem item);

}
