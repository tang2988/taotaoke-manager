
package com.taotaoke.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotaoke.mapper.TbItemMapper;
import com.taotaoke.pojo.TbItem;
import com.taotaoke.pojo.TbItemExample;

/**
 * @author 谢雄辉
 * @version 1.8
 * @date 2019年1月25日
 */
public class itemTest {

	@Test
	public void pageHelper() {
		// 指定 spring容器 获取mapper代理对象 调用查询分页方式 设置 分页

		ApplicationContext appli = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		TbItemMapper tbItemMapper = appli.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1, 15);
		List<TbItem> items = tbItemMapper.selectByExample(example);
		for (TbItem b : items) {
			System.out.println("获取所有标题" + b.getTitle());
		}
		PageInfo<TbItem> info = new PageInfo<TbItem>(items);

		long total = info.getTotal();
		System.out.println("总条数" + total);
	}

}
