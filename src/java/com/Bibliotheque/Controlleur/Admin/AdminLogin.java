package com.Bibliotheque.Controlleur.Admin;

import com.Bibliotheque.Controlleur.Login;
import com.Bibliotheque.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 2
 */
public class AdminLogin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("admin/connecter.jsp");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        User u = new User();
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
        boolean connected = u.connecter();
        if(connected) {
            u.obtenir();
            if(u.getRole().equals("admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("adminEmail",u.getEmail());
                Cookie cookie = new Cookie("adminEmail",u.getEmail());
                response.addCookie(cookie);
                try {
                    //this.getServletContext().getRequestDispatcher("/Index").forward(request, response);
                    response.sendRedirect("admin/index.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                try {
                    response.sendRedirect("admin/connecter.jsp?error=true");
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else {
            try {
                response.sendRedirect("admin/connecter.jsp?error=true");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
