<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Login</title>
</head>
<body style="text-align: center">
<h1>Login JSP</h1>

<%
    if (request.getParameter("erro") != null && request.getParameter("erro").equals("erro")) {
%>
    <h3 style="color: red;">usuário e/ou senha incorretos!</h3>
<%
    }
%>

<form method="post" action="login.jsp">
  <label for="name">Username: </label>
  <input id="name" type="text" name="usuario"/>
  <br>
  <label for="pass">Password: </label>
  <input id="pass" type="password" name="senha"/>
  <br><br>
  <input type="submit" value="Logar"/>
</form>
</body>
</html>
