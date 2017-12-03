package com.Bibliotheque.Controlleur.Admin;

import com.Bibliotheque.Controlleur.Logout;
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
public class AdminLogout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if(session != null)
            session.invalidate();
        Cookie cookie = new Cookie("adminEmail", null);
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        try {
            response.sendRedirect("admin/connecter.jsp");
        } catch (IOException ex) {
            Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
