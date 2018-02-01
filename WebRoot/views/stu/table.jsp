<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	//接收list数据
	List<Map<String, Object>> list2 = (List<Map<String, Object>>) request.getAttribute("list2");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>styles/style.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div class="formbody">
		<div class="formtitle" style="cursor: pointer;" id="formtitle">
			<span>条件查询</span>
		</div>
		<ul class="forminfo" style="display: none;" id="forminfo">
			
			<li><label>关键字</label> <input name="" type="text"
				class="dfinput" /> <i>多个关键字用,隔开</i></li>
			<li><label>&nbsp;</label> <input name="" type="button"
				class="btn" value="查询" /></li>
		</ul>
	</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th></th>
					<th>编号<i class="sort"><img src="images/px.gif" /></i></th>
					<th>姓名</th>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>电话</th>
					<th>邮箱</th>
					<th>性别</th>
					<th>地址</th>
					<th>爱好</th>
					<th>简介</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				   <td>kkkkkk</td>	
				</tr>
			</tbody>
		</table>
		<input type="hidden" id="nowpage" value="${stupage.nowpage }" />
		<input type="hidden" id="countpagenum" value="${stupage.countpagenum }" />
		<div class="pagin">
			<div class="message">
				共<i class="blue">${stupage.countnum }</i>条记录，当前显示第&nbsp;<i class="blue">${stupage.nowpage }/${stupage.countpagenum }&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li id="lup" class="paginItem "><a id="upa" href="logined?method=query&direct=up">上一页</a></li>
			<li id="ldown" class="paginItem"><a id="downa" href="logined?method=query&direct=down">下一页</a></li>
			</ul>
		</div>
	</div>

<script type="text/javascript">
	window.onload=function(){
	//通过当前页input的隐藏信息 获取当前页jquery对象
	var nowpage=$('#nowpage');
	//通过当前页input的隐藏信息 获取总页数的jquery对象
	var countnum=$('#countpagenum');
	if(nowpage.val()==1){
	//当点击下一页时添加新的样式
		$('#lup').addClass('current');
		//并且将a的超链接属性去掉
		$('#upa').removeAttr('href');
	}
	if(nowpage.val()==countnum.val()){
		$('#ldown').addClass('current');
		//并且将a的超链接属性去掉
		$('#downa').removeAttr('href');
	}
	
	}
	
	
		
</script>


	<script type="text/javascript"
		src="<%=basePath%>plugins/jQuery/jquery.js"></script>
	<script type="text/javascript">
		/**
		 * 这个使用的单选框选择判断
		 */
		function toUpdate() {
			var id = $("input[name='id']:checked").val();
			if (!id) {
				alert("请选择要操作的记录");
				return false;
			} else {
				alert("您操作的值为：" + $("input[name='id']:checked").val())
			}
		}
		$(function() {
			$('.tablelist tbody tr:odd').addClass('odd');
	
			$("#formtitle").click(function() {
				$("#forminfo").slideToggle("slow");
			});
		});
	</script>

</body>
</html>

