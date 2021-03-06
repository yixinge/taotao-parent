package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUiDateGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService ItemService;
	
	@RequestMapping("item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = ItemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUiDateGridResult getItemLsit(Integer page,Integer rows) {
		EasyUiDateGridResult result = ItemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item,String desc) throws Exception {
		TaotaoResult result = ItemService.createItem(item,desc);
		return result;
	}
	
	@RequestMapping(value="/rest/item/update",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult updateItem(TbItem item,String desc) throws Exception {
		TaotaoResult result = ItemService.updateItem(item,desc);
		return result;
	}
}












