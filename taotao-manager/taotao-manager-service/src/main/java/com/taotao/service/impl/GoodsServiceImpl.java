package com.taotao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.util.IDUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbGoodsMapper;
import com.taotao.pojo.TbGoods;
import com.taotao.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private TbGoodsMapper goodsMapper;
	
	@Override
	public TaotaoResult createGoods(TbGoods tbGoods) {
		tbGoods.setId(IDUtils.genItemId());
		tbGoods.setStatus((byte)1);
		tbGoods.setCreated(new Date());
		tbGoods.setUpdated(new Date());
		goodsMapper.insert(tbGoods);
		return TaotaoResult.ok();
	}
}
