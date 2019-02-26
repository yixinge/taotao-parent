package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbGoods;
import com.taotao.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/goods/save")
	@ResponseBody
	public TaotaoResult createGoods(TbGoods tbGoods) {
		TaotaoResult taotaoResult = goodsService.createGoods(tbGoods);
		return taotaoResult;
	}
}
