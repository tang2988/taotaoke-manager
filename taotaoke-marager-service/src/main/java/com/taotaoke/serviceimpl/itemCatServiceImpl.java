package com.taotaoke.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotaoke.common.pojo.TreeResult;
import com.taotaoke.mapper.TbItemCatMapper;
import com.taotaoke.pojo.TbItemCat;
import com.taotaoke.pojo.TbItemCatExample;
import com.taotaoke.pojo.TbItemCatExample.Criteria;
import com.taotaoke.service.itemCatService;

@Service
public class itemCatServiceImpl implements itemCatService {

	@Resource
	TbItemCatMapper tbItemCatMapper;

	public List<TreeResult> getItemCatList(Long parentId) {
		// 创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> itemCats = tbItemCatMapper.selectByExample(example);
		// 创建一个空列表
		List<TreeResult> list = new ArrayList<TreeResult>();
		// 把分类列表 itemCats 转换成 treeResult列表
		for (TbItemCat cat : itemCats) {
			TreeResult result = new TreeResult();
			result.setId(cat.getId());
			result.setText(cat.getName());
			result.setState(cat.getIsParent() ? "closed" : "open");
			list.add(result);
		}

		return list;
	}
}
