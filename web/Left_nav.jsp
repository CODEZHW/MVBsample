<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
			ul{
				width: 200px;
				height: 200px;
				float: right;
				margin-top: 30px;
			}
		</style>
	</head>
	<body>
		<ul class="nav nav-pills nav-stacked">
			<li><a href="${pageContext.request.contextPath}/QueryAllItemServlet" target="contain">ITEM</a></li>
			<li><a href="${pageContext.request.contextPath}/QueryAllStaffServlet"  target="contain">STAFF</a></li>
			<li><a href="${pageContext.request.contextPath}/QueryAllTaskServlet" target="contain">TASK</a></li>
		</ul>
	</body>
</html>
