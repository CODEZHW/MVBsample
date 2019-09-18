<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<title>企业项目任务管理系统</title>
		<style type="text/css">
			body {
				/*background-color: #eee;*/
			}
			form h1 {
				display: inline-block;
				width: 820px;
			}
			form {
				display: inline;
			}
			.contain {
				width: 1000px;
				border-radius: 10px;
				border: 1px #bbb solid;
				background-color: #eee;
				padding-top: 20px;
			}
			button {
				margin-left: 10px;
			}
			th{
				text-align: center;
				vertical-align: middle;
			}
			td{
				text-align: center;
				vertical-align: middle;
			}
			.search {
				display: inline-block;
				margin-left: 500px;
			}
			
			.add {
				float: right;
				margin-right: 50px;
			}
		</style>
	</head>
	<body>
		<div class="contain pull-left">
			<form action="" class="form-inline ">
				<h2 align="center">项目管理</h2>
			</form>
			<a href="${pageContext.request.contextPath}/AddItem.jsp" target=""><button class="btn btn-primary add">添加项目资料</button></a>
			<div class="pull-left">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>编号</th>
							<th >项目名</th>
							<th >管理人编号</th>
							<th >描述</th>
							<th >任务状态</th>
							<th >操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${item_list}" var="test" varStatus="idx">
							<tr>
								<td ><a href="${pageContext.request.contextPath}/QueryByItemIdServlet?id=${test.item_no}">${test.item_no}</a></td>
								<td >${test.item_name}</td>
								<td >${test.item_manager}</td>
								<td >${test.item_desc}</td>
								<td >${test.item_status}</td>
								<td >
									<a class="btn btn-group btn-sm" href="${pageContext.request.contextPath}/FindByValueServlet?obj=item&id=${test.item_no}">修改</a>&nbsp;
									<a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/DeleteByValueServlet?obj=item&id=${test.item_no}">删除</a>&nbsp;
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>