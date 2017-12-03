package com.Bibliotheque.Controlleur.Admin;

import com.Bibliotheque.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2
 */
public class AdminUser extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String operation = request.getParameter("op");
        User user = new User();
        user.setEmail(email);
        user.obtenir();
        if(operation.equals("activer")) {
            user.setActif(1);
        }
        else if(operation.equals("desactiver")) {
            user.setActif(0);
        }
        user.modifier();
        try {
            response.sendRedirect("http://localhost:8080/Bibliotheque/admin/etudiants.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
