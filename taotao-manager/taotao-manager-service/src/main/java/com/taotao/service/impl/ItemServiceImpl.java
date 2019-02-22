package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUiDateGridResult;
import com.taotao.common.util.IDUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}
	
	@Override
	public EasyUiDateGridResult getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		EasyUiDateGridResult result = new EasyUiDateGridResult();
		result.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item) {
		item.setId(IDUtils.genItemId());
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		
		return TaotaoResult.ok();
	}

}
