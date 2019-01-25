package com.taotaoke.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotaoke.common.util.DataResult;
import com.taotaoke.mapper.TbItemMapper;
import com.taotaoke.pojo.TbItem;
import com.taotaoke.pojo.TbItemExample;
import com.taotaoke.service.itemService;

@Service
public class itemServiceImpl implements itemService {

	@Resource
	TbItemMapper itemMapper;

	public TbItem selecById(Long id) {
		/*
		 * TbItemExample example = new TbItemExample(); Criteria criteria =
		 * example.createCriteria(); criteria.andIdEqualTo(id); List<TbItem>
		 * list = itemMapper.selectByExample(example); if(list!=null &&
		 * list.size()>0){ TbItem item = list.get(0); return item; } return
		 * null;
		 */
		return itemMapper.selectByPrimaryKey(id);
	}

	/**
	 * @return 2019年1月25日
	 */
	public DataResult findByPage(int page, int rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		DataResult dataResult = new DataResult();
		dataResult.setRows(list);
		PageInfo<TbItem> info = new PageInfo<TbItem>(list);
		dataResult.setTotal(info.getTotal());
		return dataResult;
	}

}
