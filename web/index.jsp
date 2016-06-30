<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jose.Usuario" %>
<%@ page import="com.jose.LoginFilter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="usuarioBean" class="com.jose.UsuarioBean" scope="session"/>
<jsp:setProperty name="usuarioBean" property="*"/>
<html>
<head>
    <title>CRUD Usuário</title>
</head>
<body style="text-align: center">
<h1>CRUD Usuário JSP</h1>

<h3>Usuários</h3>
<table border="1" width="100%" style="border-collapse: collapse; border: 1px solid;">
    <tr>
        <td style="background: lightgrey;">Id</td>
        <td style="background: lightgrey;">Nome</td>
        <td style="background: lightgrey;">CPF</td>
        <td style="background: lightgrey;">e-mail</td>
        <td style="background: lightgrey;"></td>
    </tr>

    <c:if test="${empty usuarioBean.usuarioList}">
        <tr>
            <td>Nenhum resultado encontrado!</td>
        </tr>
    </c:if>
    <c:if test="${not empty usuarioBean.usuarioList}">
        <c:forEach items="${usuarioBean.usuarioList}" var="usuario">
            <tr>
                <td><c:out value="${usuario.id}"/>
                </td>
                <td><c:out value="${usuario.nome}"/>
                </td>
                <td><c:out value="${usuario.cpf}"/>
                </td>
                <td><c:out value="${usuario.email}"/>
                </td>
                <td>
                    <input type="button" value="Editar"
                           onclick="location.href='cadastro-usuario.jsp?id=<c:out value="${usuario.id}"/>&action=editar&nome=<c:out value="${usuario.nome}"/>&cpf=<c:out value="${usuario.cpf}"/>&email=<c:out value="${usuario.email}"/>&usuario=<%=request.getParameter("usuario")%>&password=<%=request.getParameter("senha")%>';"/>
                    <input type="button"
                           onclick="location.href='CadastroUsuario?id=<c:out value="${usuario.id}"/>&action=deletar&usuario=<%=request.getParameter("usuario")%>&senha=<%=request.getParameter("senha")%>';"
                           value="Deletar"/>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<br>
<br>
<input value="Novo" type="button"
       onclick="location.href='cadastro-usuario.jsp?action=adicionar&usuario=<%=request.getParameter("usuario")%>&password=<%=request.getParameter("senha")%>';"/>
<input value="Sair" type="button" onclick="location.href='login.jsp';"/>
</body>
</html>
