<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登录</title>
      <link rel="stylesheet" type="text/css">
  </head>
  <body style="text-align: center;">
  <div id="loginDiv">
      <form action="/javaee_zth/upload_servlet" method="post" id="form">
          <h1 style="text-align: center;color: blue;">检测结果上传页面</h1><br>
          <p>核酸试管编号:<input  type="text" name="test_no" required="required"></p><br>
          <p>状态:<select name="test_state">
            <option>unknow</option>
            <option>negative</option>
            <option>positive</option>
            </select><br><br>
          
         
          <div margin-top: 30px;style="text-align: center;">
              <input type="submit" class="button" value="提交" >
                
              <br><br><a href="login.jsp" > 返回登陆界面</a>
          </div>
          
      </form>
  </div>
  </body>
</html>