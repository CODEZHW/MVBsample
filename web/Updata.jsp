<%@ page import="com.sun.jdi.Value" %><%--
  Created by IntelliJ IDEA.
  User: USERzhw
  Date: 2019/9/11
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<title>修改项目</title>
		<style type="text/css">
			.form-control {
				width: 300px;
				height: 30px;
				float: right;
			}
			select {
				width: 210px;
				height: 30px;
			}
			.submit {
				margin-left: 100px;
				margin-right: 30px;
			}
			.contain {
				width: 1000px;
				border: 1px #bbb solid;
				background-color: #eee;
				padding-top: 20px;
				border-radius: 10px;
			}
			label {
				display: inline-block;
				width: 100px;
				margin-right: 10px;
			}
			form {
				margin-left: 300px;
			}
		</style>
	</head>

	<body>
		<div class="contain">
			<form action="${pageContext.request.contextPath}/UpdataServlet" >
				<div class="form-group form-inline">
					<label>项目编号:</label>
				<input type="text" class="form-control"  name="item_no" maxlength="25"  value="${value_list.item_no}">
				</div>
				<div class="form-group form-inline">
					<label >项目名称:</label>
						<input type="text" class="form-control"  name="item_name" maxlength="25"  value="${value_list.item_name}">
				</div>
				<div class="form-group form-inline">
					<label >项目经理:</label>
						<input type="text" class="form-control"  name="item_manager" maxlength="25"  value="${value_list.item_manager}">
				</div>
				<div class="form-group form-inline" >
					<label >项目描述:</label>
					<input type="text" class="form-control"  name="item_desc" maxlength="25"  value="${value_list.item_desc}">
				</div>
				<div class="form-group form-inline">
					<label >项目状态:</label>
					<input type="text" class="form-control"  name="item_status"  value="${value_list.item_status}">
				</div>
				<div class="form-group form-inline">
					<input type="submit" id="" name="" class="btn btn-primary submit" />
					<input type="reset" href="${pageContext.request.contextPath}/FindByValueServlet" class="btn btn-warning" value="重置" />
				</div>

			</form>
		</div>
		<%
			request.getSession ().setAttribute ( "obj_name" ,"item");
		%>
	</body>
</html>