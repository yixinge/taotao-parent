package com.taotao.service;

import com.taotao.common.pojo.EasyUiDateGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	
	EasyUiDateGridResult getItemList(int page,int rows);
	
	TaotaoResult createItem(TbItem item);
}
