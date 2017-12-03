package com.Bibliotheque.Filtre;

import com.Bibliotheque.Model.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class SignupFiltre implements Filter {
    
    private ServletContext context;
    
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        String email = request.getParameter("email");
        String cin = request.getParameter("cin");
        String password = request.getParameter("password");
        
        if(password.length() < 4) {
            response.sendRedirect("http://localhost:8080/Bibliotheque/inscrire.jsp?errorCode=0");
        }
        else if (!(cin.matches("[0-9]+") && cin.length() == 8 )) {
            response.sendRedirect("http://localhost:8080/Bibliotheque/inscrire.jsp?errorCode=1");
        }
        else if(!validEmail(email)) {
            response.sendRedirect("http://localhost:8080/Bibliotheque/inscrire.jsp?errorCode=2");
        }
        else {
            User u = new User();
            u.setEmail(email);
            u.obtenir();
            if(u.getPassword() == null) {
                chain.doFilter(req, res);
            }
            else
                response.sendRedirect("http://localhost:8080/Bibliotheque/inscrire.jsp?errorCode=3");
        }
    }

    public boolean validEmail(String email) {
        String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void destroy() {
        
    }
    
}
