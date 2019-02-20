package com.taotao.service;

import com.taotao.common.pojo.EasyUiDateGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	EasyUiDateGridResult getItemList(int page,int rows);
}
