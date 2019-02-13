package com.taotaoke.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.mapper.TbItemParamMapper;
import com.taotaoke.pojo.TbItemParam;
import com.taotaoke.pojo.TbItemParamExample;
import com.taotaoke.service.itemParamService;

@Service
public class itemParamServiceImpl implements itemParamService {

	@Resource
	TbItemParamMapper paramMapper;

	/**
	 * 查询规格参数表 带分页
	 *谢雄辉
	 *version 1.8
	 *2019年2月13日
	 *@param page
	 *@param rows
	 *@return
	 */
	
	public DataResult finditemParamAndPage(int page, int rows) {
		//创建查询条件
		TbItemParamExample example = new TbItemParamExample();
		//设置分页参数信息 第一个参数表示当前页 第二个参数表示 一页显示多少条数据
		PageHelper.startPage(page, rows);
		
		 List<TbItemParam> list = paramMapper.selectByExample(example);
		 DataResult  dataResult = new DataResult();
		 //获取总条数
		 PageInfo<TbItemParam> pageInfo = new PageInfo<TbItemParam>(list);
		 dataResult.setRows(list);
		 dataResult.setTotal(pageInfo.getTotal());
		return dataResult;
	}
	
	
}
