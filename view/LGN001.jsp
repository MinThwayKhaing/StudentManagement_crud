<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="test.css">
<title> Student Registration LGN001 </title>
</head>
  
<body class="login-page-body"> 
   
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
         
            <h1>Welcome!</h1>
            <marquee direction='up'style=color:red;>${error}</marquee>
            
          </div>
             
           </div>
        <form action="LoginServlet" method="post">
          <input type="text" name="userid" />
          <input type="password" name="password" />
          <button>login</button>
          <p class="message">Not registered? <a href="USR001.jsp">Create an account</a></p>
        </form>
      </div>
    </div>
</body>

</html>