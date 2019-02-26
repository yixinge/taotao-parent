<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="goodsAddForm" class="goodsForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>名称:</td>
	            <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>品牌:</td>
	            <td><input class="easyui-textbox" type="text" name="brand"  style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td><input class="easyui-textbox" type="text" name="unit"  style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="num" data-options="min:1,max:99999999,precision:2,required:true" /></td>
	        </tr>
	        <tr>
	            <td>单价（元）:</td>
	            <td><input class="easyui-numberbox" type="text" name="price" data-options="min:1,max:99999999,precision:2,required:true" /></td>
	        </tr>
	        <tr>
	            <td>合价（元）</td>
	            <td>
	                <input class="easyui-numberbox" type="text" name="sumprice" data-options="min:1,max:99999999,precision:2" />
	            </td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="description"></textarea>
	            </td>
	        </tr>
	        <tr class="params hide">
	        	<td>商品规格:</td>
	        	<td>
	        		
	        	</td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = TAOTAO.createEditor("#goodsAddForm [name=description]");
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "goodsAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#goodsAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		//$("#goodsAddForm [name=price]").val(eval($("#goodsAddForm [name=price]").val()) * 100);
		//同步文本框中的商品描述
		itemAddEditor.sync();
		//取商品的规格
		/*
		var paramJson = [];
		$("#goodsAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		//把json对象转换成字符串
		paramJson = JSON.stringify(paramJson);
		$("#goodsAddForm [name=itemParams]").val(paramJson);
		*/
		//ajax的post方式提交表单
		//$("#goodsAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("/goods/save",$("#goodsAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增食材成功!');
			}
		});
	}
	
	function clearForm(){
		$('#goodsAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
