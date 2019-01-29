package com.taotaoke.service;

import java.util.List;

import com.taotaoke.common.util.TreeResult;

public interface itemCatService {

	public List<TreeResult> getItemCatList(Long parentId);

}
