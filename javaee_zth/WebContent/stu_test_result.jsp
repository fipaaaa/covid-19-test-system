<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登录</title>
      <link rel="stylesheet" type="text/css" href="ktvcss/login.css">
  </head>
  <body style="text-align: center;">
  <div id="loginDiv">
      <form action="/javaee_zth/student_getsample_servlet" method="post" id="form">
          <h1 style="text-align: center;color: blue;">核酸检测信息系统</h1><br>
          <p>学号:<input  type="text" name="stu_number" required="required"><label id="name_trip"></label></p>
          <div margin-top: 30px;style="text-align: center;">
              <input type="submit" class="button" value="登录" >
                
              <input type="reset" class="button" value="重置"><br>
              <a href="register.jsp" >    还没有账号？点击注册</a>
          </div>
          
      </form>
  </div>
  </body>
</html>