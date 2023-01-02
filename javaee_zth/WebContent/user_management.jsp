<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能选择</title>
</head>
<body style="text-align: center;">
       <h1 style="text-align: center;color: blue;">用户管理页面</h1><br>
       <br>
       <tr>
       <a href="manage_register.jsp" style="text-align: center;">注册特殊用户</a>
       </tr>
       <br>
       <br>
        <tr>
       <form action="/javaee_zth/manageallservlet" method="post" style="text-align: center;">  
             <input type="submit" value="查看所有用户"/>
    </form> 
       </tr>
       
</body>
</html>