package com.taotaoke.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotaoke.common.util.JsonUtils;
import com.taotaoke.mapper.TbItemParamItemMapper;
import com.taotaoke.pojo.TbItemParamItem;
import com.taotaoke.pojo.TbItemParamItemExample;
import com.taotaoke.pojo.TbItemParamItemExample.Criteria;
import com.taotaoke.service.ItemParamItemService;

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

	@Resource
	TbItemParamItemMapper itemMapper;

	public String getItemParamByItemId(Long itemId) {
		// 根据商品id查询规格参数
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> itemParamItems = itemMapper.selectByExampleWithBLOBs(example);
		if (itemParamItems == null || itemParamItems.size() == 0) {
			return "";
		}
		// 取规格参数信息
		TbItemParamItem item = itemParamItems.get(0);
		String paramData = item.getParamData();
		// 把规格参数json数据转换成java对象
		List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
		StringBuffer sb = new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
		sb.append("    <tbody>\n");
		for (Map m1 : jsonList) {
			sb.append("        <tr>\n");
			sb.append("            <th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
			sb.append("        </tr>\n");
			List<Map> list2 =(List<Map>) m1.get("params");
			for (Map m2 : list2) {
				sb.append("        <tr>\n");
				sb.append("            <td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
				sb.append("            <td>" + m2.get("v") + "</td>\n");
				sb.append("        </tr>\n");
			}
		}
		sb.append("    </tbody>\n");
		sb.append("</table>");
		return sb.toString();

	}

}
