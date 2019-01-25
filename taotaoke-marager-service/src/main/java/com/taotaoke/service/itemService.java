package com.taotaoke.service;

import com.taotaoke.common.util.DataResult;
import com.taotaoke.pojo.TbItem;

public interface itemService {

	public TbItem selecById(Long id);

	public DataResult findByPage(int page,int rows);

}
