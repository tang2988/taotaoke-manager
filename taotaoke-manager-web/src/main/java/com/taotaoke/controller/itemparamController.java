package com.taotaoke.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.pojo.TbItemParam;
import com.taotaoke.service.itemParamService;

@Controller
@RequestMapping(value = "/item/param/")
public class itemparamController {

	@Resource
	itemParamService itemparamservice;

	@RequestMapping("list")
	@ResponseBody
	public DataResult finditemParam(Integer page, Integer rows) {
		DataResult dataResult = itemparamservice.finditemParamAndPage(page, rows);
		return dataResult;
	}

	@RequestMapping("query/itemcatid/{itemCatId}")
	public TaotaoResult getitemparambyId(@PathVariable Long itemCatId) {
		TaotaoResult taotaoResult = itemparamservice.getitemParamById(itemCatId);
		return taotaoResult;
	}

	@RequestMapping("save/{cid}")
	@ResponseBody
	public TaotaoResult insertitemParent(@PathVariable Long cid, String paramData) {
		TbItemParam tbItemParam = new TbItemParam();
		tbItemParam.setItemCatId(cid);
		tbItemParam.setParamData(paramData);
		TaotaoResult result = itemparamservice.createItemParent(tbItemParam);
		return result;
	}

}
