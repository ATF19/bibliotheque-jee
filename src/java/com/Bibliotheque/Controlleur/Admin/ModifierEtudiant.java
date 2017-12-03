package com.Bibliotheque.Controlleur.Admin;

import com.Bibliotheque.Model.Etudiant;
import com.Bibliotheque.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ModifierEtudiant extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Etudiant etud = new Etudiant();
        etud.setId(id);
        etud.obtenir();
        
        User user = new User();
        user.setEmail(etud.getEmail());
        user.supprimer();
        etud.supprimer();
        try {
            response.sendRedirect("http://localhost:8080/Bibliotheque/admin/etudiants.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AjouterCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String dateN = "";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date) dateFormat.parse(request.getParameter("dateN"));
            dateN = formatter.format(date).toString();
            Etudiant etudiant = new Etudiant();
            etudiant.setId(id);
            etudiant.obtenir();
            etudiant.setCin(request.getParameter("cin"));
            etudiant.setCarteE(request.getParameter("carteE"));
            etudiant.setNom(request.getParameter("nom"));
            etudiant.setPrenom(request.getParameter("prenom"));
            etudiant.setDateN(dateN);
            etudiant.setUniversite(request.getParameter("universite"));
            etudiant.modifier();
            try {
                response.sendRedirect("http://localhost:8080/Bibliotheque/admin/etudiants.jsp");
            } catch (IOException ex) {
                Logger.getLogger(AjouterCategorie.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ModifierEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
