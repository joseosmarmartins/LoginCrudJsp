package com.jose;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/CadastroUsuario")
public class CadastroUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action").equals("deletar")) {
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            Usuario usuario = UsuarioDAO.porId(Integer.parseInt(request.getParameter("id")));

            UsuarioDAO.deletaUsuario(usuario);

            response.sendRedirect("index.jsp?usuario=" + user + "&senha=" + senha);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action").equals("null")) {
            adicionaNovo(request, response);
        }

        if (request.getParameter("action").equals("adicionar")) {
            adicionaNovo(request, response);
        }

        if (request.getParameter("action").equals("editar")) {
            editaUsuario(request, response);
        }
    }

    public void adicionaNovo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));

        UsuarioDAO.adicionarUsuario(usuario);

        if (request.getParameter("usuario").equals("null") && request.getParameter("password").equals("null")) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("index.jsp?usuario=" + request.getParameter("usuario") + "&senha=" + request.getParameter("password"));
        }
    }

    public void editaUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setId(Integer.valueOf(request.getParameter("id")));
        usuario.setNome(request.getParameter("nome"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));

        UsuarioDAO.editaUsuario(usuario);

        if (request.getParameter("usuario").equals("null") && request.getParameter("password").equals("null")) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("index.jsp?usuario=" + request.getParameter("usuario") + "&senha=" + request.getParameter("password"));
        }
    }
}
