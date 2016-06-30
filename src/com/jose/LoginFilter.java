package com.jose;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}, urlPatterns = {"/login.jsp"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Inicializando filtro...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getParameter("usuario") != null && servletRequest.getParameter("senha") != null) {
            String usuario = servletRequest.getParameter("usuario");
            String senha = servletRequest.getParameter("senha");

            Usuario u = UsuarioDAO.porNomeSenha(usuario, senha);

            if(u != null && u.getNome() != null && u.getSenha() != null) {
                RequestDispatcher rd = servletRequest.getRequestDispatcher("index.jsp?usuario=" + usuario + "&senha=" + senha);
                rd.include(servletRequest, servletResponse);
            }
            else{
                RequestDispatcher rd = servletRequest.getRequestDispatcher("login.jsp?erro=erro");
                rd.include(servletRequest, servletResponse);
            }
        } else {
            RequestDispatcher rd = servletRequest.getRequestDispatcher("login.jsp");
            rd.include(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destruindo filtro...");
    }
}
