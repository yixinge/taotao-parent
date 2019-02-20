package com.taotao.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

	@Test
	public void testPageHelper() {
		//创建一个spring容器，获得Mapper的代理对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		//执行查询，并分页。
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1,10);
		List<TbItem> list = mapper.selectByExample(example);
		for (TbItem tbItem : list) {
			System.out.println("title:"+tbItem.getTitle());
		}
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		System.out.println("共有："+pageInfo.getTotal());
	}
}
