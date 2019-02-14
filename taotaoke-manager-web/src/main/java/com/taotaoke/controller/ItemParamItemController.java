package com.taotaoke.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotaoke.service.ItemParamItemService;

@Controller
public class ItemParamItemController {
	@Resource
	ItemParamItemService itemParamService;

	@RequestMapping("/item/{itemId}")
	public String showItemParam(@PathVariable Long itemId, Model model) {
		String string = itemParamService.getItemParamByItemId(itemId);
		model.addAttribute("itemParam", string);
		return "item";
	}

}
