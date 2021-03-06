package com.taotaoke.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.common.util.IDUtils;
import com.taotaoke.mapper.TbItemDescMapper;
import com.taotaoke.mapper.TbItemMapper;
import com.taotaoke.mapper.TbItemParamItemMapper;
import com.taotaoke.pojo.TbItem;
import com.taotaoke.pojo.TbItemDesc;
import com.taotaoke.pojo.TbItemExample;
import com.taotaoke.service.itemParamService;
import com.taotaoke.service.itemService;

@Service
public class itemServiceImpl implements itemService {

	@Resource
	TbItemMapper itemMapper;

	@Resource
	TbItemDescMapper descMapper;

	@Resource
	itemParamService itemparamservice;

	public TbItem selecById(Long id) {
		/*
		 * TbItemExample example = new TbItemExample(); Criteria criteria =
		 * example.createCri teria(); criteria.andIdEqualTo(id); List<TbItem>
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
		// 创建查询条件
		TbItemExample example = new TbItemExample();
		// 设置分页参数 第一个参数 表示1页 第二个参数 在当前页显示条数据
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		// 创建一个空的 数据结果集
		DataResult dataResult = new DataResult();
		// 设置数据
		dataResult.setRows(list);
		// 获取总量
		PageInfo<TbItem> info = new PageInfo<TbItem>(list);
		dataResult.setTotal(info.getTotal());
		return dataResult;
	}

	public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception {

		// 填充数据
		long itemid = IDUtils.genItemId();
		item.setId(itemid);
		item.setStatus((byte) 1);
		item.setUpdated(new Date());
		item.setCreated(new Date());
		// 插入到数据库
		itemMapper.insert(item);
		// 添加商品描述
		TaotaoResult result = createitemdesc(itemid, desc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}

		// 添加规格参数
		result = itemparamservice.insertItemParamItem(itemid, itemParam);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		return TaotaoResult.ok();
	}

	/**
	 * 商品描述添加 谢雄辉 version 1.8 2019年2月13日
	 * 
	 * @return
	 */
	public TaotaoResult createitemdesc(Long itemId, String desc) {
		TbItemDesc record = new TbItemDesc();
		record.setCreated(new Date());
		record.setItemId(itemId);
		record.setUpdated(new Date());
		record.setItemDesc(desc);
		descMapper.insert(record);
		return TaotaoResult.ok();

	}

	public TaotaoResult updateItem(TbItem item) {

		itemMapper.updateByPrimaryKey(item);
		return TaotaoResult.ok();
	}

	public TaotaoResult delItem(Long id) {
		itemMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}

}