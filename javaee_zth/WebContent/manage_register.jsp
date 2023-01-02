<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>注册</title>  
     <link rel="stylesheet" type="text/css">
</head>  
<body style="text-align: center;">  
    <div id="registerdiv">  
           
        <form action="/javaee_zth/manage_register_servlet" method="post">  
         <h1 style="text-align: center;color: blue;">特殊人员注册</h1><br>
          
           <tr>
           <td><p>工作人员用户名:<input  id="guest_username_new" type="text" required="required"  name="worker_username"></p></td>
           </tr>
           <tr>
            <p>工作人员密码:<input id="guest_password_new" type="text" required="required"  name="worker_password"></label> </p>
            </tr>
            <tr>
            <p>工作人员姓名:<input id="guest_name_new" type="text" required="required"  name="worker_name"></p>
            </tr>
            <tr>
            <p>工作人员编号:<input id="guest_tel_new" type="text" required="required"  name="worker_number"> </p>
            </tr>
            <tr>
            <p>工作人员权限:<select name="worker_level">
            <option>doctor</option>
            <option>uploader</option>
            <option>admin</option>
            </select>
            </tr>
            <br>
            <br>
             <div margin-top: 30px;style="text-align: center;">
              <input type="submit" class="button" value="注册" >  
              <input type="reset" class="button" value="重置"><br>
              <br>
              <a href="user_management.jsp">前往人员管理页面</a>
          </div>
        </form>  
    </div>  
</body>  
</html> 