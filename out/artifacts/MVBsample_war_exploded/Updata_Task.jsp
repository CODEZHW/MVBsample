<%--
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
    <title>修改任务</title>
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
            <label >任务编号:</label>
            <input type="text" class="form-control"  name="task_no" maxlength="25" required="required" value="${value_list.task_no}">
        </div>
        <div class="form-group form-inline">
            <label >任务名称:</label>
            <input type="text" class="form-control"  name="task_name" maxlength="25" required="required" value="${value_list.task_name}">
        </div>
        <div class="form-group form-inline">
            <label >任务描述:</label>
            <input type="text" class="form-control" name="task_desc" maxlength="25" required="required" value="${value_list.task_desc}">
        </div>
        <div class="form-group form-inline" >
            <label >任务所属项目:</label>
            <input type="text" class="form-control"  name="task_of_item" maxlength="25" required="required" value="${value_list.task_of_item}">
        </div>
        <div class="form-group form-inline">
            <label >任务优先级:</label>
            <input type="text" class="form-control" name="task_priority" required="required" value="${value_list.task_priority}">
        </div>
        <div class="form-group form-inline">
            <label >任务状态:</label>
            <input type="text" class="form-control"  name="task_status" required="required" value="${value_list.task_status}">
        </div>
        <div class="form-group form-inline">
            <label >任务开始时间:</label>
            <input type="text" class="form-control"  name="task_start_time" required="required" value="${value_list.task_start_time}">
        </div>
        <div class="form-group form-inline">
            <label >任务结束时间:</label>
            <input type="text" class="form-control"  name="task_end_time" required="required" value="${value_list.task_end_time}">
        </div>
        <div class="form-group form-inline">
            <label >任务负责人:</label>
           <input type="text" class="form-control"  name="task_of_staff" required="required" value="${value_list.task_of_staff}">
        </div>
        <div class="form-group form-inline">
            <input type="submit" id="" name="" class="btn btn-primary submit" />
            <input type="reset" href="${pageContext.request.contextPath}/FindByValueServlet" class="btn btn-warning" value="重置" />
        </div>

    </form>
</div>
<%
    request.getSession ().setAttribute ( "obj_name" ,"task");
    System.out.println ( "test" );
%>
</body>

</html>
