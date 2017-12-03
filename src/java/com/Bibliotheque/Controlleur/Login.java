package com.Bibliotheque.Controlleur;

import com.Bibliotheque.Model.User;
import java.io.IOException;
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
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletContext().getRequestDispatcher("/connecter.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            HttpSession session = request.getSession();
            session.setAttribute("email",u.getEmail());
            Cookie cookie = new Cookie("email",u.getEmail());
            response.addCookie(cookie);
            try {
                //this.getServletContext().getRequestDispatcher("/Index").forward(request, response);
                response.sendRedirect("Index");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
        else {
            request.setAttribute("error", true);
            try {
                this.getServletContext().getRequestDispatcher("/connecter.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
