package com.taotaoke.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.common.pojo.DataResult;
import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.pojo.TbItem;
import com.taotaoke.service.itemService;

@Controller

/**
 * @author 谢雄辉
 * @version 1.8
 * @date 2019年1月25日
 */
public class itemController {

	@Resource
	itemService itemService;

	/**
	 * 根据商品id查询
	 * 
	 * @author 谢雄辉
	 * @version 1.8
	 * @return 2019年1月25日
	 */
	@RequestMapping("/item/{itemid}")
	@ResponseBody
	public TbItem rejson(@PathVariable Long itemid) {
		TbItem item = itemService.selecById(itemid);
		return item;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public DataResult itemlist(Integer page, Integer rows) {
		DataResult dataResult = itemService.findByPage(page, rows);
		return dataResult;
	}

	/**
	 * 添加商品
	 * 
	 * @param item
	 * @return taotaoResult
	 * @throws Exception
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
		TaotaoResult taotaoResult = itemService.createItem(item, desc, itemParams);
		return taotaoResult;
	}

	/**
	 * 加载編輯页面
	 * 
	 * @param itemedit
	 * @return itemedit
	 */
	@RequestMapping("/rest/page/{itemedit}")

	public String changeItem(@PathVariable String itemedit) {

		return itemedit;
	}

	@RequestMapping("/rest/item/update")
	@ResponseBody
	public TaotaoResult changeItem(TbItem item) {
		item.setUpdated(new Date());
		item.setCreated(new Date());
		TaotaoResult result = itemService.updateItem(item);
		return result;

	}

	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public TaotaoResult deleteItem(Long id) {
		TaotaoResult taotaoResult = itemService.delItem(id);
		return taotaoResult;
	}

}
