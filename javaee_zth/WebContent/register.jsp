<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>注册</title>  
     <link rel="stylesheet" type="text/css">
</head>  
<body style="text-align: center;">  
    <div id="registerdiv">  
           
        <form action="/javaee_zth/register_servlet" method="post" id=form onsubmit="return  RegisterSubmit()">  
         <h1 style="text-align: center;color: blue;">学生注册</h1><br>
          
           <tr>
           <td><p> 用户名:<input  id="guest_username_new" type="text" required="required"  name="guest_username_new"></p></td>
           </tr>
           <tr>
            <p>密码:<input id="guest_password_new" type="text" required="required"  name="guest_password_new"></label> </p>
            </tr>
            <tr>
            <p>姓名:<input id="guest_name_new" type="text" required="required"  name="guest_name_new"></p>
            </tr>
            <tr>
            <p>学号:<input id="guest_tel_new" type="text" required="required"  name="guest_stu_number_new"> </p>
            </tr>
          
            <br>
             <div margin-top: 30px;style="text-align: center;">
              <input type="submit" class="button" value="注册" >  
              <input type="reset" class="button" value="重置"><br>
              <a href="login.jsp">前往登陆</a>
          </div>
        </form>  
    </div>  
    <script>
      function RegisterSubmit() {
          var tel=document.getElementById("guest_stu_number_new");
          var re = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/

          if (!re.test(tel.value))

          {

          alert("学号输入格式不正确");

          tel.focus();

          return false;

          }
      }
  </script>
</body>  
</html> 
