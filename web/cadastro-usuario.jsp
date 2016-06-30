<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Novo Usuário</title>
</head>
<body style="text-align: center;">
<h1>Novo Usuário</h1>
<form action="CadastroUsuario" method="post">
    <input type="hidden" value="<%=request.getParameter("action")%>" name="action">
    <input type="hidden" value="<%=request.getParameter("id")%>" name="id">
    <input type="hidden" value="<%=request.getParameter("usuario")%>" name="usuario">
    <input type="hidden" value="<%=request.getParameter("password")%>" name="password">

    <label for="nome">Nome:</label>
    <input id="nome" type="text" name="nome" value="<%=request.getParameter("nome") != null ? request.getParameter("nome") : ""%>">

    <br>
    <label for="cpf">CPF:</label>
    <input id="cpf" type="text" name="cpf" value="<%=request.getParameter("cpf") != null ? request.getParameter("cpf") : ""%>">

    <br>
    <label for="email">E-Mail:</label>
    <input id="email" type="text" name="email" value="<%=request.getParameter("email") != null ? request.getParameter("email") : ""%>">

    <br>
    <label for="senha">Senha:</label>
    <input id="senha" type="password" name="senha" value="<%=request.getParameter("senha") != null ? request.getParameter("senha") : ""%>">

    <br>
    <br>
    <%
        if (request.getParameter("id") != null) {
    %>
    <input type="submit" value="Editar">
    <%
        } else {
    %>
    <input type="submit" value="Adicionar">
    <%
        }
    %>
    <input type="button" onclick="location.href='index.jsp?usuario=<%=request.getParameter("usuario")%>&password=<%=request.getParameter("senha")%>';" value="Cancelar"/>
</form>
</body>
</html>
