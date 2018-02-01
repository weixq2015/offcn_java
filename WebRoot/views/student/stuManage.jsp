<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<base href="<%=basePath%>">
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/Styles/bootstrap.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/Styles/admin-all.css"/>"/>
<!-- easyui引入js和css start-->

<script type="text/javascript" src="<c:url value="/Scripts/jquery-1.7.2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/themes/default/easyui.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/themes/icon.css"/>"/>
<script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>

<!-- easyui引入js和css end-->

<script type="text/javascript">
	$(function() {
		initTable();
	});

    function initTable(){
      //alert(page1);
      $('#dg').datagrid({
			singleSelect : false,// 复选框单选还是多选
			emptyMsg : '暂时没有相关信息！',
			pagination : true,
			url : 'stu/list',
			method : 'post'
		});
    }
	
	
	function searchCustomer(){
	 $("#dg").datagrid('load',{
		"name":$("#s_name").val(),
		"classid":$("#classidkey").combobox("getValue")
	 });
   }
   
   function deleteCustomer(){
	 var selectedRows=$("#dg").datagrid("getSelections");
	 if(selectedRows.length==0){
		 $.messager.alert("系统提示","请选择要删除的数据！");
		 return;
	 }
	 var strIds=[];
	 for(var i=0;i<selectedRows.length;i++){
		 strIds.push(selectedRows[i].id);
	 }
	 var ids=strIds.join(",");
	 $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
		if(r){
			$.post("${pageContext.request.contextPath}/stu/delete",{ids:ids},function(result){
				if(result.success){
					 $.messager.alert("系统提示","数据已成功删除！");
					 $("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","数据删除失败，请联系系统管理员！");
				}
			},"json");
		} 
	 });
 }
	
	var url;
	function openCustomerAddDialog(){
	 $("#dlg").dialog("open").dialog("setTitle","添加学生信息");
	 url="${pageContext.request.contextPath}/stu/addSave.do";
    }
    
    
    
    function saveCustomer(){
	 $("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			if($("#sex").combobox("getValue")==""){
				$.messager.alert("系统提示","请选择性别!");
				return false;
			}
			if($("#classid").combobox("getValue")==""){
				$.messager.alert("系统提示","请选择班级!");
				return false;
			}
			return $(this).form("validate");
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.success){
				$.messager.alert("系统提示","保存成功！");
				resetValue();
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
			}else{
				$.messager.alert("系统提示","保存失败！");
				$("#dlg").dialog("close");
				return;
			}
		}
	 });
 }
 
 function resetValue(){
	 $("#name").val("");
	 $("#loginname").val("");
	 $("#password").val("");
	 $("#sex").combobox("setValue","");
	 $("#tel").val("");
	 $("#classid").combobox("setValue","");
	 $("#address").val("");
 }
 
 function closeCustomerDialog(){
	 $("#dlg").dialog("close");
	 resetValue();
 }
 
 
 function openCustomerModifyDialog(){
	 var selectedRows=$("#dg").datagrid("getSelections");
	 if(selectedRows.length!=1){
		 $.messager.alert("系统提示","请选择一条要编辑的数据！");
		 return;
	 }
	 var row=selectedRows[0];
     alert(row);
     console.info(row);
	 $("#dlg").dialog("open").dialog("setTitle","编辑学生信息");
	 $("#fm").form("load",row);//数据的反选
	 url="${pageContext.request.contextPath}/stu/addSave?id="+row.id;
 }
 

</script>

</head>
<body>

	<div class="alert alert-info">
		当前位置<b class="tip"></b>学生管理<b class="tip"></b>学生列表   
	</div>
	
	<div id="tb">
	 	<div>
	 		<a href="javascript:openCustomerAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a>
	 		<a href="javascript:openCustomerModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
	 		<a href="javascript:deleteCustomer()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	 	</div>
	 	<div>
	 		&nbsp;学生姓名：&nbsp;<input type="text" id="s_name" size="20" onkeydown="if(event.keyCode==13) searchCustomer()"/>
	 		   				<input class="easyui-combobox" id="classidkey" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/stu/add'"/>&nbsp;<font color="red">*</font>
	 	<a href="javascript:searchCustomer()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
	 	</div>
    </div>

    <table id="dg" class="easyui-datagrid"
					style="width: 100%; min-width: 800px; height: 80%">
					<thead>
						<tr>
							<!-- <th data-options="field:'id',hidden:true"></th> -->
							<th data-options="field:'id',checkbox:true"></th> 
							<th
								data-options="field : 'rowIndex',
										sortable : 'false',
										halign : 'center',
										align : 'center',formatter : function(value, row, index) {
											return index+1;
										}
										">序号</th>

							<th data-options="field:'name',editor:'text',sortable:'false'"
								width="30%">姓名</th>
							<th data-options="field:'tel',editor:'text',sortable:'true'"
								width="20%">联系方式</th>
							<th data-options="field:'address',editor:'text',sortable:'true'"
								width="20%">居住地址</th>
						    <!-- <th data-options="field:'sex',editor:'text',sortable:'true',formatter:managerStatusFormat"
								width="20%">性别</th> -->
							<th data-options="resizable:true,field:'sex',
							   formatter: function (value, row, index) {
							       if(value==0||value=='0'){
							          return '男';   
							       }
							       if(value==1||value=='1'){
							          return '女';   
							       }
							       if(value==2||value=='0'){
							          return '0';   
							       }
							          
							    }" width="20%">性别</th>
							    
						</tr>
			</thead>
	  </table>
	  
  <div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
   <form id="fm" method="post">
   	<table cellspacing="8px">
   		<tr>
   			<td>学生姓名：</td>
   			<td><input type="text" id="name" name="name" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
   			<td>登录名：</td>
   			<td><input type="text" id="loginname" name="loginname" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
   		</tr>
   		
   		<tr>
   			<td>密码：</td>
   			<td><input type="text" id="password" name="password" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
   			<td>性别：</td>
   			<td>
                <select class="easyui-combobox" id="sex" name="sex" style="width: 154px" editable="false" panelHeight="auto">
   					<option value="">请选择...</option>
   					<option value="1">男</option>	
					<option value="2">女</option>	
                </select>&nbsp;<font color="red">*</font>    			
             </td>
   		</tr>
   		<tr>
   			<td>学生电话：</td>
   			<td><input type="text" id="tel" name="tel" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
   			<td>居住地址：</td>
   			<td><input type="text" id="address" name="address" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
   		</tr>
   		
   		<tr>
   			<td>班级：</td>
   			<td>
   				<input class="easyui-combobox" id="classid" name="classid" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/stu/add'"/>&nbsp;<font color="red">*</font>
   			</td>
   		</tr>
   		
   		
   	</table>
   </form>
 </div> 
 
 <div id="dlg-buttons">
 	<a href="javascript:saveCustomer()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
 	<a href="javascript:closeCustomerDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
 </div>
	  
	  
</body>
</html>
