package com.Bibliotheque.Filtre;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 2
 */
public class AdminFilter implements Filter {
    
    private ServletContext context;
    
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
      
        
        HttpSession session = request.getSession(false);
        if(session == null) {
            response.sendRedirect("http://localhost:8080/Bibliotheque/admin/connecter.jsp");
        }
        else {
            if(session.getAttribute("adminEmail") == "" || session.getAttribute("adminEmail") == null) {
                response.sendRedirect("http://localhost:8080/Bibliotheque/admin/connecter.jsp");
            }
            else {
                chain.doFilter(req, res);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void destroy() {
        
    }
    
}
