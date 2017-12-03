package com.Bibliotheque.Controlleur;

import com.Bibliotheque.Model.Etudiant;
import com.Bibliotheque.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Signup extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletContext().getRequestDispatcher("/inscrire.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String dateN = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = (Date) dateFormat.parse(request.getParameter("dateN"));
            dateN = formatter.format(date).toString();
            Etudiant etudiant = new Etudiant();
            etudiant.setCin(request.getParameter("cin"));
            etudiant.setCarteE(request.getParameter("carteE"));
            etudiant.setNom(request.getParameter("nom"));
            etudiant.setPrenom(request.getParameter("prenom"));
            etudiant.setEmail(request.getParameter("email"));
            etudiant.setDateN(dateN);
            etudiant.setUniversite(request.getParameter("universite"));
            boolean resEtudiant = etudiant.ajouter();
            User u = new User();
            u.setEmail(request.getParameter("email"));
            u.setPassword(request.getParameter("password"));
            u.setRole("etudiant");
            u.setActif(0);
            boolean resUser = u.ajouter();
            if(resUser && resEtudiant) {
                response.sendRedirect("connecter.jsp");
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
        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("error", true);
            try {
                this.getServletContext().getRequestDispatcher("/inscrire.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

