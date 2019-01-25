/**
 * 2019年1月25日Administrator
 */
package com.taotaoke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 谢雄辉
 * @version 1.8
 * @date 2019年1月25日
 */
@Controller
public class pagecontroller {

	/**
	 * 后台管理首页跳转
	 * 
	 * @version 1.8
	 * @return 2019年1月25日
	 */
	@RequestMapping(value = "/")
	public String showindex() {
		return "index";
	}

	@RequestMapping("/{page}")
	/**
	 * 展示其它页面
	 * 
	 * @author 谢雄辉
	 * @version 1.8
	 * @return page 2019年1月25日
	 */
	public String page(@PathVariable String page) {
		return page;
	}
}
